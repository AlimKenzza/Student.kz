package dao;

import model.News;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class NewsDao extends Dao<News> {
    List<News> newsList = new LinkedList<>();

    @Override
    public List<News> fetch() {
        try {
            getConnection();
            query = "SELECT * From news";
            pStatement = connection.prepareStatement(query);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int postId = resultSet.getInt(1);
                String title = resultSet.getString(2);
                String body = resultSet.getString(3);
                int clubId = resultSet.getInt(4);
                Date postDate = resultSet.getDate(5);

                News news = new News(postId, title, body, clubId, postDate);
                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return newsList;
    }

    @Override
    public void add(News news) {
        try {
            getConnection();
            query = "Insert into news(post_id,title,body,club_id,postdate) VALUES (?,?,?,?,?)";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, news.getPostId());
            pStatement.setString(2, news.getTitle());
            pStatement.setString(3, news.getBody());
            pStatement.setInt(4, news.getClubId());
            pStatement.setDate(5, (java.sql.Date) news.getPostDate());
            pStatement.executeUpdate();
            System.out.println("News successfully added.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public void edit(News news) {
        try {
            getConnection();
            query = "UPDATE news SET title = ?, body = ?, club_id = ?, postdate = ? WHERE post_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, news.getTitle());
            pStatement.setString(2, news.getBody());
            pStatement.setInt(3, news.getClubId());
            pStatement.setDate(4, (java.sql.Date) news.getPostDate());
            pStatement.setInt(5, news.getPostId());
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public void delete(int id) {
        try {
            getConnection();
            query = "DELETE FROM news WHERE post_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public News get(int id) {
        News news = new News();
        try {
            getConnection();
            query = "SELECT * From news where post_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                String title = resultSet.getString("title");
                String body = resultSet.getString("body");
                int clubId = resultSet.getInt("club_id");
                Date postDate = resultSet.getDate("postdate");

                news.setPostId(id);
                news.setTitle(title);
                news.setBody(body);
                news.setClubId(clubId);
                news.setPostDate(postDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return news;
    }
}

