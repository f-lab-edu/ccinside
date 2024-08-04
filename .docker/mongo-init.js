db.createUser(
    {
      user: "ccinside",
      pwd: "1234",
      roles: [
        {
          role: "readWrite",
          db: "ccinside_local"
        }
      ]
    }
);

db = db.getSiblingDB('ccinside_local')

db.post.insertMany([
  {
    title: 'Post 1',
    author_no: 1,
    gallery_no: 1,
    post_views: 100,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    title: 'Post 2',
    author_no: 2,
    gallery_no: 1,
    post_views: 200,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    title: 'Post 3',
    author_no: 3,
    gallery_no: 1,
    post_views: 300,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    title: 'Post 4',
    author_no: 4,
    gallery_no: 1,
    post_views: 400,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    title: 'Post 5',
    author_no: 5,
    gallery_no: 1,
    post_views: 500,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  }
]);

// trending_post 컬렉션 데이터 삽입
db.trending_post.insertMany([
  {
    post_no: 1,
    title: 'Trending Post 1',
    author_no: 1,
    gallery_no: 1,
    post_views: 1000,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    post_no: 2,
    title: 'Trending Post 2',
    author_no: 2,
    gallery_no: 1,
    post_views: 2000,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    post_no: 3,
    title: 'Trending Post 3',
    author_no: 3,
    gallery_no: 1,
    post_views: 3000,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    post_no: 4,
    title: 'Trending Post 4',
    author_no: 4,
    gallery_no: 1,
    post_views: 4000,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  },
  {
    post_no: 5,
    title: 'Trending Post 5',
    author_no: 5,
    gallery_no: 1,
    post_views: 5000,
    unit_time: 'ONE_HOUR',
    created_at: new Date()
  }
]);