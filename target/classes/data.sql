
insert into employees values(101,'tommy@email.com','Tom');  
insert into employees values(102,'andrew007@email.com','Andrew');  
insert into employees values(103,'tony123@email.com','Tony');  
insert into employees values(104,'bob@email.com','Bob');  
insert into employees values(105,'sam@email.com','Sam');  


insert into attendance values(1001,CURRENT_DATE,101,PARSEDATETIME('10:10:10','hh:mm:ss'),PARSEDATETIME('20:10:10','hh:mm:ss'));
insert into attendance values(1002,PARSEDATETIME('2020-02-10', 'yyyy-MM-dd'),101,PARSEDATETIME('09:01:10','hh:mm:ss'),PARSEDATETIME('18:10:10','hh:mm:ss'));
insert into attendance values(1003,PARSEDATETIME('2020-01-01', 'yyyy-MM-dd'),102,PARSEDATETIME('10:10:10','hh:mm:ss'),PARSEDATETIME('18:10:10','hh:mm:ss'));
insert into attendance values(1004,PARSEDATETIME('2020-01-02', 'yyyy-MM-dd'),102,PARSEDATETIME('10:20:10','hh:mm:ss'),PARSEDATETIME('20:20:10','hh:mm:ss'));
insert into attendance values(1005,PARSEDATETIME('2020-01-01', 'yyyy-MM-dd'),103,PARSEDATETIME('08:05:10','hh:mm:ss'),PARSEDATETIME('19:05:10','hh:mm:ss'));
insert into attendance values(1006,PARSEDATETIME('2020-01-01', 'yyyy-MM-dd'),104,PARSEDATETIME('11:18:10','hh:mm:ss'),PARSEDATETIME('16:18:10','hh:mm:ss'));
insert into attendance values(1007,CURRENT_DATE,103,PARSEDATETIME('08:05:10','hh:mm:ss'),null);
insert into attendance values(1008,PARSEDATETIME('2020-02-08', 'yyyy-MM-dd'),104,PARSEDATETIME('12:18:10','hh:mm:ss'),PARSEDATETIME('12:18:10','hh:mm:ss'));
insert into attendance values(1009,CURRENT_DATE,102,PARSEDATETIME('08:05:10','hh:mm:ss'),null);