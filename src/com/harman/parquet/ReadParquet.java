package com.harman.parquet;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.column.page.PageReadStore;
import org.apache.parquet.example.data.Group;
import org.apache.parquet.example.data.simple.convert.GroupRecordConverter;
import org.apache.parquet.format.converter.ParquetMetadataConverter;
import org.apache.parquet.hadoop.ParquetFileReader;
import org.apache.parquet.hadoop.metadata.ParquetMetadata;
import org.apache.parquet.io.ColumnIOFactory;
import org.apache.parquet.io.MessageColumnIO;
import org.apache.parquet.io.RecordReader;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.Type;

public class ReadParquet {
	//D:\\simmons_data_Generation\\simmons\\master_data\\dimensions\\Simmons_Dictionary_Master\\Simmons_Dictionary.parquet	
	// C:\\myfile.snappy.parquet	
	// D:\\simmons_data_Generation\\simmons\\master_data\\connectors\\Simmons_Dictionary_Master\\Simmons_Dictionary.parquet
	// D:\\spark\\python_Script\\simmons\\master_data\\connectors\\Simmons_Dictionary_Master\\Simmons_Dictionary.parquet
		private static Path path = new Path("file:\\D:\\spark\\python_Script\\simmons\\master_data\\connectors\\Simmons_Dictionary_Master\\part-r-00192-853b8020-c777-435e-ad7b-831fac0339bd.snappy.parquet");
		 
		  private static void printGroup(Group g) {
		    int fieldCount = g.getType().getFieldCount();
		    for (int field = 0; field < fieldCount; field++) {
		      int valueCount = g.getFieldRepetitionCount(field);
		 
		      Type fieldType = g.getType().getType(field);
		      String fieldName = fieldType.getName();
		 
		      for (int index = 0; index < valueCount; index++) {
		        if (fieldType.isPrimitive()) {
		          System.out.println(fieldName + " " + g.getValueToString(field, index));
		        }
		      }
		    }
		    System.out.println("");
		  }
		 
		  public static void main(String[] args) throws IllegalArgumentException {
		 System.out.println("Test");
		    Configuration conf = new Configuration();
		 
		    try {
		      ParquetMetadata readFooter = ParquetFileReader.readFooter(conf, path, ParquetMetadataConverter.NO_FILTER);
		      MessageType schema = readFooter.getFileMetaData().getSchema();
		      ParquetFileReader r = new ParquetFileReader(conf, path, readFooter);
		 
		      PageReadStore pages = null;
		      try {
		        while (null != (pages = r.readNextRowGroup())) {
		          final long rows = pages.getRowCount();
		          System.out.println("Number of rows: " + rows);
		 
		          final MessageColumnIO columnIO = new ColumnIOFactory().getColumnIO(schema);
		          final RecordReader recordReader = columnIO.getRecordReader(pages, new GroupRecordConverter(schema));
		          for (int i = 0; i < rows; i++) {
		            final Group g = (Group) recordReader.read();
		            printGroup(g);
		 
		            // TODO Compare to System.out.println(g);
		          }
		        }
		      } finally {
		        r.close();
		      }
		    } catch (IOException e) {
		      System.out.println("Error reading parquet file.");
		      e.printStackTrace();
		    }
		  }
	
}
