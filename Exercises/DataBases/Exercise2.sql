
select asd
into new_table
from Studens;

select *
from new_table;

select *
from (	select 1 as i
	union all
	select 2)as t1
cross join
(	select 3 as i
	union all
	select 4
	union all
	select 5) as t2

--natural join

select *
from students natural join applications;

select *
from students s join applications a on s.sid = a.sid;

select *
from students join applications using (sid);