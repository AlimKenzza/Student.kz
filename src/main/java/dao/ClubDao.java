package dao;

import model.Club;

import java.sql.SQLException;
import java.util.*;

public class ClubDao extends Dao<Club> {
    Stack<Club> clubs = new Stack<>();

    @Override
    public Stack<Club> fetch() {
        try {
            getConnection();
            query = "SELECT * From clubs";
            pStatement = connection.prepareStatement(query);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int memberCount = resultSet.getInt(3);
                String leader = resultSet.getString(4);

                Club club = new Club(id, name, memberCount, leader);
                clubs.add(club);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return clubs;
    }

    @Override
    public void add(Club club) {
        try {
            getConnection();
            query = "Insert into clubs(club_id, club_name, members_count,leader) VALUES (?,?,?,?)";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, club.getClubId());
            pStatement.setString(2, club.getClubName());
            pStatement.setInt(3, club.getMemberCount());
            pStatement.setString(4, club.getLeader());
            pStatement.executeUpdate();
            System.out.println("Club successfully added.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public void edit(Club club) {
        try {
            getConnection();
            query = "UPDATE clubs SET club_name = ?, members_count = ?, leader = ? WHERE club_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, club.getClubName());
            pStatement.setInt(2, club.getMemberCount());
            pStatement.setString(3, club.getLeader());
            pStatement.setInt(4, club.getClubId());
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
            query = "DELETE FROM clubs WHERE club_id = ?";
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
    public Club get(int id) {
        Club club = new Club();
        try {
            getConnection();
            query = "SELECT * From clubs where club_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(2);
                int memberCount = resultSet.getInt(3);
                String leader = resultSet.getString(4);

                club.setClubId(id);
                club.setClubName(name);
                club.setMemberCount(memberCount);
                club.setLeader(leader);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return club;
    }
}
