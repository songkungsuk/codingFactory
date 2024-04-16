public class Main {

    public static void main(String[] args) {
        String schema = "column_name;data_type;column_comment\n"
            + "USER_PK;bigint;\n"
            + "USER_ID;varchar;\n"
            + "PASSWORD;varchar;\n"
            + "USER_NM;varchar;\n"
            + "MOBLPHON_NO;varchar;\n"
            + "EMAIL;varchar;\n"
            + "EMAIL_AT;varchar;\n"
            + "ZIPCODE;varchar;\n"
            + "ADDR;varchar;\n"
            + "AUTH_TP;varchar;\n"
            + "ADDR_DETAIL;varchar;\n"
            + "DEL_AT;varchar;\n"
            + "REG_USER_ID;varchar;\n"
            + "REG_DTM;datetime;\n"
            + "UPD_USER_ID;varchar;\n"
            + "UPD_DTM;datetime;\n"
            + "ATCH_FL_PK;bigint;";

        System.out.println(VOGenerator.generateVOClass(schema));
    }
}