insert IGNORE into user(id,about,address,email,enabled,image_url,name,password,phone,signature,uname,depar) values (1, '', '', '', true, '', 'admin','$2a$10$VM.KjsbVKZF1I4Rk9TWyCu4InmPoCE9zjvGQ1VMBgJY1uXPjKZ4Rm','','','admin',0);
                        


INSERT  IGNORE INTO roles VALUES  (1, 'ADMIN');
INSERT  IGNORE INTO roles VALUES  (2, 'DEAN');
INSERT  IGNORE INTO roles VALUES  (3, 'QUALITY');
INSERT  IGNORE INTO roles VALUES  (4, 'APO');
INSERT  IGNORE INTO roles VALUES  (5, 'CHAIR_HOLDER');
INSERT  IGNORE INTO roles VALUES  (6, 'COURSE_CHAIR');
INSERT  IGNORE INTO roles VALUES  (7, 'ADVISOR');
INSERT  IGNORE INTO roles VALUES  (8, 'INSTRUCTOR');
INSERT  IGNORE INTO roles VALUES  (9, 'ASSISTANT');
INSERT  IGNORE INTO roles VALUES  (10,'STUDENT');

INSERT  IGNORE INTO users_roles VALUES  (1,1);
/* for feedback */
INSERT  IGNORE INTO switcch VALUES  (1,0);
INSERT  IGNORE INTO switcch VALUES  (2,0);
/* for performance */
INSERT  IGNORE INTO switcch VALUES  (3,0);
INSERT  IGNORE INTO switcch VALUES  (4,0);

INSERT  IGNORE INTO fmie VALUES  (1,'Manufacturing Engineering');
INSERT  IGNORE INTO fmie VALUES  (2,'Mechanical Design');
INSERT  IGNORE INTO fmie VALUES  (3,'Automotive and Electromechanical Engineering');
INSERT  IGNORE INTO fmie VALUES  (4,'Agricultural Mechanization Engineering');
INSERT  IGNORE INTO fmie VALUES  (5,'Production Systems Engineering');
INSERT  IGNORE INTO fmie VALUES  (6,'Industrial Design and Management Science');
INSERT  IGNORE INTO fmie VALUES  (7,'Thermal Engineering');
INSERT  IGNORE INTO fmie VALUES  (8,'FMIE');

INSERT  IGNORE INTO year VALUES  (1,'1<sup>st</sup>');
INSERT  IGNORE INTO year VALUES  (2,'2<sup>nd</sup>');
INSERT  IGNORE INTO year VALUES  (3,'3<sup>rd</sup>');
INSERT  IGNORE INTO year VALUES  (4,'4<sup>th</sup>');
INSERT  IGNORE INTO year VALUES  (5,'5<sup>th</sup>');
INSERT  IGNORE INTO year VALUES  (6,'6<sup>th</sup>');
INSERT  IGNORE INTO year VALUES  (7,'7<sup>th</sup>');

INSERT  IGNORE INTO semester VALUES  (1,'I');
INSERT  IGNORE INTO semester VALUES  (2,'II');
INSERT  IGNORE INTO semester VALUES  (3,'III');

INSERT  IGNORE INTO groupt VALUES  (1,'Mechanical Engineering');
INSERT  IGNORE INTO groupt VALUES  (2,'Automotive Engineering');
INSERT  IGNORE INTO groupt VALUES  (3,'Industrial Engineering');
INSERT  IGNORE INTO groupt VALUES  (4,'Electro-Mechanical Engineering');
INSERT  IGNORE INTO groupt VALUES  (5,'Engineering Drawing And Design');



