# HanabiJava
hanabi for learning java

#note
* 注意1：运行需要将web/WEB-INF/lib.zip 的lib解压，然后添加到 WEB-INF 中，并add as library
* 注意2：数据库需要使用mysql ，并建立相应的表和数据库，参考c3p0-config.xml 文件和 UserDao.java 文件的设置
* 注意3：java需要和jdbc的版本匹配，在使用过程中，使用java version "1.8.0_211" 和 jdbc  mysql-connector-java-5.1.37-bin.jar 版本，结果老是提示  "com.mysql. jdbc. exceptions. jdbc4 MySQL NonTransientConnectionException: Could not create connection to database server." 之后使用java version "1.8.0_211" 和 mysql-connector-java-8.0.11.jar之后连接成功