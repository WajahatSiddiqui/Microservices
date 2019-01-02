This application demonstrates mongo db usage by exposing User
resource which is persisted in mongo db


#Command to run mongo db
$ mongod --dbpath <path_to_folder_where_mongodb_will_store_data>

#Output
2019-01-02T19:02:23.485+0530 I NETWORK  [listener] connection accepted from 127.0.0.1:44176 #1 (1 connection now open)
2019-01-02T19:02:23.492+0530 I NETWORK  [conn1] received client metadata from 127.0.0.1:44176 conn1: { driver: { name: "mongo-java-driver", version: "3.8.2" }, os: { type: "Linux", name: "Linux", architecture: "amd64", version: "4.4.0-138-generic" }, platform: "Java/Oracle Corporation/1.8.0_172-b11" }
2019-01-02T19:02:24.095+0530 I NETWORK  [listener] connection accepted from 127.0.0.1:44178 #2 (2 connections now open)
2019-01-02T19:02:24.096+0530 I NETWORK  [conn2] received client metadata from 127.0.0.1:44178 conn2: { driver: { name: "mongo-java-driver", version: "3.8.2" }, os: { type: "Linux", name: "Linux", architecture: "amd64", version: "4.4.0-138-generic" }, platform: "Java/Oracle Corporation/1.8.0_172-b11" }
2019-01-02T19:02:24.108+0530 I STORAGE  [conn2] createCollection: mongo.user with generated UUID: 00dc6ad3-d067-473e-9ad8-9e6242a4b9e4
2019-01-02T19:02:24.330+0530 I WRITE    [conn2] update mongo.user command: { q: { _id: 1 }, u: { _id: 1, name: "Wajahat", email: "wajahat.s@xyz.com", _class: "com.wajahat.mongodb.demomongodb.document.User" }, multi: false, upsert: true } planSummary: IDHACK keysExamined:0 docsExamined:0 nMatched:0 nModified:0 upsert:1 keysInserted:1 numYields:0 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } 222ms
2019-01-02T19:02:24.330+0530 I COMMAND  [conn2] command mongo.$cmd command: update { update: "user", ordered: true, $db: "mongo" } numYields:0 reslen:107 locks:{ Global: { acquireCount: { r: 3, w: 3 } }, Database: { acquireCount: { w: 2, W: 1 } }, Collection: { acquireCount: { w: 2 } } } protocol:op_msg 222ms

#GET http://localhost:8080/api/users
[{"id":1,"name":"Wajahat","email":"wajahat.s@xyz.com","teamName":null},{"id":2,"name":"Siddiqui","email":"siddiqui.w@xyz.com","teamName":null}]