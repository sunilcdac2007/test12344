package com.harman.work;

/*
 * Decompiled with CFR 0_118.
 * 
 * Could not load the following classes:
 *  com.symphonyam.mobile.utility.ACREvent
 *  com.symphonyam.utility.DBConnectionUtility
 */


import com.symphonyam.mobile.utility.ACREvent;
import com.symphonyam.utility.DBConnectionUtility;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class VideoEventProcessor {
    public static String MATCH = "MATCH";
    public static int SKIP_THRESHOLD = 180000;
    Properties dbProps = new Properties();
    ArrayList<ACREvent> acrEvents = null;

    public VideoEventProcessor() {
        try {
            this.dbProps.load(this.getClass().getResourceAsStream("datasource.properties"));
        }
        catch (Exception ex) {
            this.dbProps = null;
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            VideoEventProcessor videoEvtProc = new VideoEventProcessor();
            videoEvtProc.processEvents();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void processEvents() throws Exception {
        block45 : {
            elapsedTime_0 = 0;
            elapsedTime_1 = 0;
            elapsedTime_2 = 0;
            elapsedTime_3 = 0;
            connection = this.initilizeConnectionVertica();
            connection_vertica = this.initilizeConnectionVertica();
            insert_verticaconn = this.initilizeConnectionVertica();
            deviceRs = null;
            deviceStmt = null;
            if (connection == null) ** GOTO lbl174
            this.acrEvents = new ArrayList<E>();
            try {
                try {
                    deviceSql = "SELECT DISTINCT DEVICE_DIM_ID FROM SAM_VTXN.VTXN_ACR_TXN_DTL";
                    deviceStmt = connection.createStatement();
                    deviceRs = deviceStmt.executeQuery(deviceSql);
                    execStartTime = new Date().getTime();
                    System.out.println("Execution start time:::" + execStartTime);
                    while (!deviceRs.isLast()) {
                        block42 : {
                            block43 : {
                                block41 : {
                                    this.acrEvents = new ArrayList<E>();
                                    deviceRs.next();
                                    deviceDimID = deviceRs.getString("DEVICE_DIM_ID");
                                    System.out.println("Started processing elapsedTime for device ID:" + deviceDimID);
                                    sql = "SELECT TIME_ID_FILE_TS, ID,DEVICE_DIM_ID,USERS_META_ID, EVENT, PRG_TITLE,CHANNEL_NAME, DT_TIMESTAMP, to_TIMESTAMP(DT_TIMESTAMP/1000) AS DATE_TIME,PRG_START_TIME_ORIG  FROM SAM_VTXN.VTXN_ACR_TXN_DTL WHERE IS_PROCESSED=0 AND DEVICE_DIM_ID='" + deviceDimID + "' " + "ORDER BY DEVICE_DIM_ID, DT_TIMESTAMP";
                                    resultSet = null;
                                    statement = null;
                                    moveToNextRs = true;
                                    if (connection == null || connection_vertica == null) ** GOTO lbl128
                                    try {
                                        statement = connection_vertica.createStatement();
                                        resultSet = statement.executeQuery(sql);
                                        if (resultSet == null) break block41;
                                        block12 : while (!resultSet.isLast()) {
                                            if (moveToNextRs) {
                                                resultSet.next();
                                            }
                                            moveToNextRs = true;
                                            time_id = resultSet.getLong("TIME_ID_FILE_TS");
                                            id_0 = resultSet.getLong("ID");
                                            device_id_0 = resultSet.getString("DEVICE_DIM_ID");
                                            email_0 = resultSet.getString("USERS_META_ID");
                                            event_type_0 = resultSet.getString("EVENT");
                                            prg_title_0 = resultSet.getString("PRG_TITLE");
                                            channel_title_0 = resultSet.getString("CHANNEL_NAME");
                                            timestamp_ev0 = resultSet.getString("DT_TIMESTAMP");
                                            date_time0 = resultSet.getString("DATE_TIME");
                                            if (resultSet.isLast()) continue;
                                            if (moveToNextRs) {
                                                resultSet.next();
                                            }
                                            moveToNextRs = true;
                                            time_id = resultSet.getLong("TIME_ID_FILE_TS");
                                            id_1 = resultSet.getLong("ID");
                                            device_id_1 = resultSet.getString("DEVICE_DIM_ID");
                                            event_type_1 = resultSet.getString("EVENT");
                                            timestamp_ev1 = resultSet.getString("DT_TIMESTAMP");
                                            prg_title_1 = resultSet.getString("PRG_TITLE");
                                            channel_title_1 = resultSet.getString("CHANNEL_NAME");
                                            date_time1 = resultSet.getString("DATE_TIME");
                                            if (!device_id_1.equals(device_id_0)) {
                                                moveToNextRs = false;
                                                continue;
                                            }
                                            if (!event_type_1.equals(VideoEventProcessor.MATCH)) ** GOTO lbl101
                                            elapsedTime_0 = new BigInteger(timestamp_ev1).longValue() - new BigInteger(timestamp_ev0).longValue();
                                            this.updateElapsedTime(insert_verticaconn, id_0, elapsedTime_0, 1, prg_title_0, channel_title_0, event_type_0, date_time0, id_1, time_id);
                                            moveToNextRs = false;
                                            continue;
lbl-1000: // 1 sources:
                                            {
                                                if (moveToNextRs) {
                                                    resultSet.next();
                                                }
                                                moveToNextRs = true;
                                                time_id = resultSet.getLong("TIME_ID_FILE_TS");
                                                id_2 = resultSet.getLong("ID");
                                                event_type_2 = resultSet.getString("EVENT");
                                                timestamp_ev2 = resultSet.getString("DT_TIMESTAMP");
                                                prg_title_2 = resultSet.getString("PRG_TITLE");
                                                channel_title_2 = resultSet.getString("CHANNEL_NAME");
                                                date_time2 = resultSet.getString("DATE_TIME");
                                                device_id_2 = resultSet.getString("DEVICE_DIM_ID");
                                                elapsedTime_2 = new BigInteger(timestamp_ev2).longValue() - new BigInteger(timestamp_ev1).longValue();
                                                elapsedTime_1 = new BigInteger(timestamp_ev1).longValue() - new BigInteger(timestamp_ev0).longValue();
                                                elapsedTime_3 = new BigInteger(timestamp_ev2).longValue() - new BigInteger(timestamp_ev0).longValue();
                                                if (!device_id_2.equals(device_id_1)) {
                                                    moveToNextRs = false;
                                                    continue block12;
                                                }
                                                if (elapsedTime_2 >= (long)VideoEventProcessor.SKIP_THRESHOLD) {
                                                    this.updateElapsedTime(insert_verticaconn, id_0, elapsedTime_1, 1, prg_title_0, channel_title_0, event_type_0, date_time0, id_1, time_id);
                                                    this.updateElapsedTime(insert_verticaconn, id_1, elapsedTime_2, 1, prg_title_1, channel_title_1, event_type_1, date_time1, id_2, time_id);
                                                    moveToNextRs = false;
                                                    continue block12;
                                                }
                                                this.updateElapsedTime(insert_verticaconn, id_1, elapsedTime_2, 1, prg_title_1, channel_title_1, event_type_1, date_time1, id_2, time_id);
                                                if (elapsedTime_2 < (long)VideoEventProcessor.SKIP_THRESHOLD && event_type_2.equals(VideoEventProcessor.MATCH)) {
                                                    this.updateElapsedTime(insert_verticaconn, id_0, elapsedTime_3, 1, prg_title_0, channel_title_0, event_type_0, date_time0, id_2, time_id);
                                                    moveToNextRs = false;
                                                    continue block12;
                                                }
                                                id_1 = id_2;
                                                event_type_1 = event_type_2;
                                                timestamp_ev1 = timestamp_ev2;
                                                prg_title_1 = prg_title_2;
                                                channel_title_1 = channel_title_2;
                                                event_type_1 = event_type_2;
                                                date_time1 = date_time2;
lbl101: // 2 sources:
                                                ** while (!resultSet.isLast())
                                            }
lbl102: // 1 sources:
                                        }
                                    }
                                    catch (SQLException e) {
                                        System.out.println(e.getMessage());
                                        if (resultSet != null) {
                                            resultSet.close();
                                        }
                                        if (statement != null) {
                                            statement.close();
                                        }
                                        break block42;
                                    }
                                    catch (Exception ex) {
                                        try {
                                            System.out.println(ex.getMessage());
                                        }
                                        catch (Throwable var49_45) {
                                            throw var49_45;
                                        }
                                        finally {
                                            if (resultSet != null) {
                                                resultSet.close();
                                            }
                                            if (statement != null) {
                                                statement.close();
                                            }
                                        }
                                    }
                                }
                                if (resultSet == null) break block43;
                                resultSet.close();
                            }
                            if (statement != null) {
                                statement.close();
                            }
                        }
                        System.out.println("Completed processing elapsed time for deviceID " + deviceDimID);
                        System.out.println("Checking Rs here...." + deviceRs);
                        this.insertElapsedTimeForDevice(insert_verticaconn);
                    }
                    execEndTime = new Date().getTime();
                    resultSet = execEndTime - execStartTime;
                }
                catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    if (deviceRs != null) {
                        deviceRs.close();
                    }
                    if (deviceStmt != null) {
                        deviceStmt.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                    if (connection_vertica != null) {
                        connection_vertica.close();
                    }
                    if (insert_verticaconn != null) {
                        insert_verticaconn.close();
                    }
                    break block45;
                }
            }
            catch (Throwable var50_46) {
                if (deviceRs != null) {
                    deviceRs.close();
                }
                if (deviceStmt != null) {
                    deviceStmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (connection_vertica != null) {
                    connection_vertica.close();
                }
                if (insert_verticaconn != null) {
                    insert_verticaconn.close();
                }
                throw var50_46;
            }
            if (deviceRs != null) {
                deviceRs.close();
            }
            if (deviceStmt != null) {
                deviceStmt.close();
            }
            if (connection != null) {
                connection.close();
            }
            if (connection_vertica != null) {
                connection_vertica.close();
            }
            if (insert_verticaconn != null) {
                insert_verticaconn.close();
            }
        }
        System.out.println("******** Finished processing all devices for elapsed time calculation ******");
lbl174: // 2 sources:
    }

    private void updateElapsedTime(Connection conn, long rowID, long elapsedTime, int isProcessed, String progName, String channelName, String eventType, String date_time, long END_ID, long time_id) throws Exception {
        ACREvent acrEvent = new ACREvent();
        acrEvent.rowID = rowID;
        acrEvent.elapsedTime = elapsedTime;
        acrEvent.endRowID = END_ID;
        acrEvent.fileTimeID = time_id;
        this.acrEvents.add(acrEvent);
    }

    private void insertElapsedTimeForDevice(Connection conn) throws Exception {
        if (conn != null && this.acrEvents != null && this.acrEvents.size() > 0) {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO SAMDB.SAM_VTXN.VTXN_TV_TXN_DTL_APP values(?,?,?,?,?)");
            int i = 0;
            while (i < this.acrEvents.size()) {
                ACREvent currACREvent = this.acrEvents.get(i);
                pstmt.setLong(1, currACREvent.rowID);
                pstmt.setLong(2, currACREvent.elapsedTime);
                pstmt.setLong(3, currACREvent.endRowID);
                boolean isProcessed = true;
                pstmt.setLong(4, (long)isProcessed ? 1 : 0);
                pstmt.setLong(5, currACREvent.fileTimeID);
                pstmt.addBatch();
                ++i;
            }
            pstmt.executeBatch();
        }
    }

    private static void updateIsProcessed(int isProcessed) throws Exception {
    }

    private String getDataSourceProperty(String propKey) throws Exception {
        if (this.dbProps == null) {
            throw new Exception("Data Source properties could not be loaded. DB connection cannot be performed");
        }
        String propVal = this.dbProps.getProperty(propKey);
        return propVal;
    }

    private Connection initilizeConnection() throws Exception {
        Connection con = null;
        try {
            con = DBConnectionUtility.initilizeConnection();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    private Connection initilizeConnectionVertica() throws Exception {
        Connection con = null;
        try {
            con = DBConnectionUtility.initializeVerticaConnection();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
