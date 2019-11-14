create table browse (
   browseid             int                  not null,
   userid               int                  not null,
   movieid              int                  not null,
   browsetime           datetime             not null default getdate(),
   constraint PK_BROWSE primary key nonclustered (browseid)
)


create table comment (
   commentid            int                 not null,
   userid               int                  not null,
   movieid              int                  not null,
   text                 varchar(1000)        not null,
   time                 datetime             not null default getdate(),
   score                int                  not null,
   constraint PK_COMMENT primary key nonclustered (commentid),
   constraint AK_USERID_COMMENT unique (userid, movieid)
)

create table direct (
   directorid           int                  not null,
   movieid              int                  not null,
   constraint PK_DIRECT primary key nonclustered (directorid, movieid)
)

create table director (
   directorid           int                 not null,
   name                 varchar(100)         not null,
   sex                  varchar(10)          not null,
   birthday             datetime             not null,
   birthplace           varchar(100)         not null,
   profile              varchar(2000)        not null,
   constraint PK_DIRECTOR primary key nonclustered (directorid)
)

create table "like" (
   userid               int                  not null,
   commentid            int                  not null,
   constraint PK_LIKE primary key nonclustered (userid, commentid)
)

create table movie (
   movieid              int                 not null,
   moviename            varchar(100)         not null,
   screenwriter         varchar(500)         not null,
   actor                varchar(1000)        not null,
   type                 varchar(50)          not null,
   country              varchar(100)         not null,
   language             varchar(50)          not null,
   releasetime          datetime             not null,
   duration             int                  not null,
   introduction         varchar(2000)        not null,
   constraint PK_MOVIE primary key nonclustered (movieid)
)

create table "user" (
   userid               int                 not null,
   username             varchar(20)          not null,
   password             varchar(20)          not null,
   email                varchar(50)          not null,
   constraint PK_USER primary key nonclustered (userid),
   constraint AK_USERNAME_USER unique (username)
)
