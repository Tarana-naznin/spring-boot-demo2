USE trellodb;
CREATE TABLE tProjects (
                           rid int not null,
                           name varchar(255) not null,
                           description varchar(255),
                           issueKey varchar(10) not null,
                           CONSTRAINT PK_tProjects PRIMARY KEY (rid)
);


--lead (user who is the project lead)
--avatar (image or icon representing the project)

CREATE TABLE tIssue (
                        rid int not null,
                        projectid int not null, ##(foreign key to project table)
                        title varchar(255) not null,
                        description varchar(400),
                        created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated timestamp not null,
                        duedate timestamp,
                        CONSTRAINT PK_tIssue PRIMARY KEY (rid),
                        CONSTRAINT FK_tProjects FOREIGN KEY (projectid)
                            REFERENCES tProjects(rid)
);

--issuetype (type of issue, e.g., bug, task, story)
--priority (issue priority, e.g., High, Medium, Low)
--assignee (user assigned to the issue)
--status (current status of the issue, e.g., Open, In Progress)

CREATE TABLE tUser (
                       rid int not null,
                       firstName VARCHAR(255) not null,
                       lastName VARCHAR(255) not null,
                       displayname VARCHAR(255) not null,
                       active tinyint(1) not null default 1,
                       CONSTRAINT PK_tUser PRIMARY KEY (rid)
);

CREATE TABLE tAccount (
                      rid int not null,
                      userid int not null,
                      username VARCHAR(100) not null UNIQUE,
                      password VARCHAR(255) not null,  ##(hashed password)
                      email VARCHAR(100),
                      active tinyint(1) not null default 1,
                      CONSTRAINT PK_tAccount PRIMARY KEY (rid),
                      CONSTRAINT FK_tUser FOREIGN KEY (userid)
                          REFERENCES tUser(rid)
);
--role (type of issue, e.g., admin, developer)

CREATE TABLE tIssueStatus (
                              rid int not null,
                              name varchar(255) not null,
                              description varchar(400),
                              CONSTRAINT PK_tIssueStatus PRIMARY KEY (rid)
);

CREATE TABLE tWorkflow (
                           rid int not null,
                           name varchar(255) not null,
                           description varchar(400),
                           active tinyint(1) not null default 1,
                           CONSTRAINT PK_tWorkflow PRIMARY KEY (rid)
);

CREATE TABLE tWorklog (
                          rid int not null,
                          comment varchar(400),
                          issueid int not null,
                          authorid int not null,
                          time_worked INT UNSIGNED NOT NULL DEFAULT 0,
                          startdate TIMESTAMP not null,
                          CONSTRAINT PK_tWorkflow PRIMARY KEY (rid),
                          CONSTRAINT FK_tUser_tWorkflow FOREIGN KEY (authorid)
                              REFERENCES tUser(rid)
);


CREATE TABLE tTask (
                       rid int not null,
                       title varchar(255) not null,
                       description varchar(400),
                       issueid int not null,
                       createdAt timestamp not null default current_timestamp,
                       dueDate TIMESTAMP not null,
                       priorityid int not null,
                       parentTaskid int not null,
                       label varchar(10),
                       workflow varchar(10),
                       assigneeid int not null,
                       CONSTRAINT PK_tTask PRIMARY KEY (rid),
                       CONSTRAINT FK_tTask_tUser FOREIGN KEY (assigneeid)
                           REFERENCES tUser(rid)
);