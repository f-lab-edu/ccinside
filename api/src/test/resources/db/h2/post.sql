INSERT INTO post (title, author_no, gallery_no, post_views, unit_time, created_at)
VALUES ('Post 1', 1, 1, 100, 'ONE_HOUR', NOW()),
       ('Post 2', 2, 1, 200, 'ONE_HOUR', NOW()),
       ('Post 3', 3, 1, 300, 'ONE_HOUR', NOW()),
       ('Post 4', 4, 1, 400, 'ONE_HOUR', NOW()),
       ('Post 5', 5, 1, 500, 'ONE_HOUR', NOW());

INSERT INTO trending_post (post_no, title, author_no, gallery_no, post_views, unit_time, created_at)
VALUES (1, 'Trending Post 1', 1, 1, 1000, 'ONE_HOUR', NOW()),
       (2, 'Trending Post 2', 2, 1, 2000, 'ONE_HOUR', NOW()),
       (3, 'Trending Post 3', 3, 1, 3000, 'ONE_HOUR', NOW()),
       (4, 'Trending Post 4', 4, 1, 4000, 'ONE_HOUR', NOW()),
       (5, 'Trending Post 5', 5, 1, 5000, 'ONE_HOUR', NOW());
       