查询sql

1.编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/second-highest-salary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

答:
思路一：过滤掉最高的薪水，然后排序取第一个
	1. 聚合函数 获取最高薪水的值 -- where <> 过滤
	
	select max(t1.salary ) as SecondHighestSalary
	from employee t1
	where t1.salary <>
	(
	select max(salary)
	from employee t2
	)
	
	2. 排序取第一个，获取最高薪水的值
		select max(t1.salary ) as SecondHighestSalary
		from employee t1
		where t1.salary <>
		(
		select t2.salary
		from employee t2
		order by t2.salary desc
		    limit 1
		)
	3. 如果是集合的话，-- where not in 过滤
				   -- 当做一张表  inner join on 
思路二: 使用分页思想
	1. 略过最高的一个
	select t1.salary as SecondHighestSalary
	from employee t1
	order by t1.salary desc
	limit 1,1
	
	2. 去重、空判断
	select ifnull(
		(select distinct salary 
		from employee
		order by salary desc
		limit 1,1)
		    ,null
		)
	as SecondHighestSalary