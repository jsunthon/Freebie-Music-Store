
    create table albums (
        album_id integer not null auto_increment,
        genre varchar(255),
        img_src varchar(255),
        album_name varchar(255),
        artist_id integer,
        primary key (album_id)
    );

    create table artists (
        artist_id integer not null auto_increment,
        artist_name varchar(255),
        primary key (artist_id)
    );

    create table comments (
        comment_id integer not null auto_increment,
        comment varchar(255),
        comment_date date,
        rating integer,
        title varchar(255),
        track_id integer,
        user_id integer,
        primary key (comment_id)
    );

    create table downloads (
        track_id integer not null,
        user_id integer not null
    );

    create table playlists (
        track_id integer not null,
        user_id integer not null
    );

    create table tracks (
        track_id integer not null auto_increment,
        audio_src varchar(255),
        count integer,
        feature boolean,
        lyric_date date,
        track_lyric longtext,
        track_name varchar(255),
        track_num integer,
        album_id integer,
        primary key (track_id)
    );

    create table upload_tracks (
        upload_id integer not null,
        name varchar(255),
        user_id integer,
        primary key (upload_id)
    );

    create table users (
        user_id integer not null auto_increment,
        email varchar(255),
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        state varchar(255),
        primary key (user_id)
    );

    alter table albums 
        add index FK_9bokmir0yccvq915bi2lsd10m (artist_id), 
        add constraint FK_9bokmir0yccvq915bi2lsd10m 
        foreign key (artist_id) 
        references artists (artist_id);

    alter table comments 
        add index FK_it6fb5et81ibskwtmwx7gjolt (track_id), 
        add constraint FK_it6fb5et81ibskwtmwx7gjolt 
        foreign key (track_id) 
        references tracks (track_id);

    alter table comments 
        add index FK_1x3vdhb5vv8eu5708riqe07wc (user_id), 
        add constraint FK_1x3vdhb5vv8eu5708riqe07wc 
        foreign key (user_id) 
        references users (user_id);

    alter table downloads 
        add index FK_oiijjxat348u3924yk85shtyh (user_id), 
        add constraint FK_oiijjxat348u3924yk85shtyh 
        foreign key (user_id) 
        references users (user_id);

    alter table downloads 
        add index FK_fvdgoi4y3ws9hvgy2aagcu7oj (track_id), 
        add constraint FK_fvdgoi4y3ws9hvgy2aagcu7oj 
        foreign key (track_id) 
        references tracks (track_id);

    alter table playlists 
        add index FK_o1cjkwid9wmumca7fc4jf1hgo (user_id), 
        add constraint FK_o1cjkwid9wmumca7fc4jf1hgo 
        foreign key (user_id) 
        references users (user_id);

    alter table playlists 
        add index FK_jwomr1d9wpn2xoxd7c2l6mg8d (track_id), 
        add constraint FK_jwomr1d9wpn2xoxd7c2l6mg8d 
        foreign key (track_id) 
        references tracks (track_id);

    alter table tracks 
        add index FK_fkc3io0y5n0p93pp4auy2ym86 (album_id), 
        add constraint FK_fkc3io0y5n0p93pp4auy2ym86 
        foreign key (album_id) 
        references albums (album_id);

    alter table upload_tracks 
        add index FK_4wv61dd73wuejn6byv7kwp2ej (user_id), 
        add constraint FK_4wv61dd73wuejn6byv7kwp2ej 
        foreign key (user_id) 
        references users (user_id);
