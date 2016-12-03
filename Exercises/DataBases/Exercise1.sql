select *
from Students
where name like '%va%'
order by avg asc;

/*
 union and union all
*/
Select Name as name
from students
union
Select Rec as name
FROM universities;

SELECT cast(1 as int) as col1
union all
select 2;

/* renaming and counting: broi kolko puti edin student e kandidatstval
group by grupira kolonite napisani v select
*/
select s.name, count(*) as application_per_student
from students as s, applications as a
where s.sid = a.sid
group by s.name
order by s.name;

--selects the students that have applied to more then 3 universities
select Name as StudentName, count(*) as appliedToUniversitiesCount
from students, applications
where students.SID = applications.SID
group by Name
having count(*) >= 3
order by Name;

--subqueries: in and exists

select name, sid
from students
where sid in (select max(sid) from applications where uname = 'TU');

select name, sid
from students s
where sid exists (	select sid 
			from applications a 
			where a.uname = 'TU'
			and s.sid=a.sid);

select *
from universities

--derived table
select *
from(select name from students where name like 'De%') as s --derived table
where ... -- subquery

