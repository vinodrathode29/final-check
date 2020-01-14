-- Include table data insertion, updation, deletion and select scripts
-- -------------------------------------------------------------------------------------
-- view Table
-- ------------------------------------------------------------------------------------

select 
mo_title as Title,
mo_box_office as BoxOffice,
mo_active as Active,
mo_date_of_launch as DateOfLaunch ,
mo_genre as Genre,
mo_has_teaser as HasTeaser
from movie;

delete from movie;

-- -------------------------------------------------------------------------------------
-- Adding Admin Movies IN Table
-- -------------------------------------------------------------------------------------
insert into movie
values
(1, 'Avatar', 2787965087,'Yes','2017-03-15','Science Fiction', 'Yes'),
(2, 'The Avengers', 1518812988, 'Yes', '2017-12-23','Superhero', 'No'),
(3, 'Titanic', 2187463944, 'Yes','2017-08-21', 'Romance', 'No'),
(4, 'Jurassic World', 1671713208, 'No', '2017-07-02','Science Fiction', 'Yes'),
(5, 'Avengers: End Game', 2750760348, 'Yes', '2022-11-02','Superhero', 'No');

-- To Display

select 
mo_title as Title,
mo_box_office as BoxOffice,
mo_active as Active,
mo_date_of_launch as DateOfLaunch ,
mo_genre as Genre,
mo_has_teaser as HasTeaser
from movie;

-- --------------------------------------------------------------------------------------
-- Update Movie
-- --------------------------------------------------------------------------------------

update movie 
set mo_title ='Basha' 
where mo_id= 1;

-- To Display

select 
mo_title as Title,
mo_box_office as BoxOffice,
mo_active as Active,
mo_date_of_launch as DateOfLaunch ,
mo_genre as Genre,
mo_has_teaser as HasTeaser
from movie;


-- --------------------------------------------------------------------------------------
-- Creating Users
-- --------------------------------------------------------------------------------------

insert into user(us_id,us_name)
 values
 
 (1,'Tyrion Lannister'),
 (2,'Sansa Stark');
 
 -- To Display
 
select 
us_id as Id,
us_name as Name 
from user;
 
delete from user;

-- --------------------------------------------------------------------------------------
-- Customer Movie List
-- --------------------------------------------------------------------------------------

select mo_title as Title,
mo_has_teaser as HasTeaser,
mo_box_office as BoxOffice,
mo_genre as Genre
from movie
where mo_active='Yes'
and mo_date_of_launch  <= (curdate()); 
 
 -- --------------------------------------------------------------------------------------
-- Inserting Items in Favorites
-- --------------------------------------------------------------------------------------

insert into favorite(fv_us_id,fv_mv_id) values (1,1),(1,3);

-- insert into favorite(fv_us_id,fv_mv_id) values (2,3);

-- --------------------------------------------------------------------------------------
-- To Display Favorites with ID
-- --------------------------------------------------------------------------------------

select 
fv_id as FavoriteId,
fv_us_id as FavUserId,
fv_mv_id as FavMovieId
from favorite;

delete from favorite;
-- --------------------------------------------------------------------------------------
--  To View Favorites after Adding
-- --------------------------------------------------------------------------------------

select  mo_title as Title,
mo_has_teaser as HasTeaser,
mo_box_office as BoxOffice
from movie
inner join favorite 
on fv_mv_id=mo_id
where fv_us_id=1;


-- Calculation of No. of Favorites

select count(mo_title) as No_of_Favorites 
from movie
inner join favorite on fv_mv_id=mo_id
where fv_us_id=1;  

-- --------------------------------------------------------------------------------------
-- To Delete an Item From Cart
-- --------------------------------------------------------------------------------------

delete from favorite
where fv_us_id=1 and fv_mv_id=3 
limit 1;

-- --------------------------------------------------------------------------------------
--  To View Cart after Deleting
-- --------------------------------------------------------------------------------------

select 
mo_title as Title,
mo_has_teaser as HasTeaser,
mo_box_office as BoxOffice 
from movie
inner join favorite 
on fv_mv_id=mo_id
where fv_us_id=1;

-- Calculation of No. of Favorites

select count(mo_title) 
as No_of_favorites 
from movie
inner join favorite on fv_mv_id=mo_id
where fv_us_id=1;  

-- --------------------------------------------------------------------------------------
-- To Display Favorites with ID After Deleting
-- --------------------------------------------------------------------------------------

select 
fv_id as FavoriteId,
fv_us_id as FavUserId,
fv_mv_id as FavMovieId
from favorite;

-- --------------------------------------------------------------------------------------