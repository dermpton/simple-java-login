module com.dermpton.userauth {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
//    requires mysql.connector.java;
    
    opens com.dermpton.userauth to javafx.fxml;
    exports com.dermpton.userauth;
    exports com.dermpton.userauth.data;
    exports com.dermpton.userauth.model;
    
}
