package dao;

import model.Event;

import java.sql.SQLException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class EventDao extends Dao<Event> {
    private final Queue<Event> events = new PriorityQueue<>();

    @Override
    public Queue<Event> fetch() {
        try {
            getConnection();
            query = "SELECT * From events";
            pStatement = connection.prepareStatement(query);
            resultSet = pStatement.executeQuery();
            while (resultSet.next()) {
                int eventId = resultSet.getInt(1);
                String eventName = resultSet.getString(2);
                Date eventDate = resultSet.getDate(3);
                int eventCost = resultSet.getInt(4);

                Event event = new Event(eventId, eventName, eventDate, eventCost);
                events.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return events;
    }

    @Override
    public void add(Event event) {
        try {
            getConnection();
            query = "Insert into events(event_id,event_name,event_date,event_cost) VALUES (?,?,?,?)";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, event.getEventId());
            pStatement.setString(2, event.getEventName());
            pStatement.setDate(3, (java.sql.Date) event.getEventDate());
            pStatement.setInt(4, event.getEventCost());
            pStatement.executeUpdate();
            System.out.println("Event successfully added.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
    }

    @Override
    public void edit(Event event) {
        try {
            getConnection();
            query = "UPDATE events SET event_name = ?, event_date = ?, event_cost = ? WHERE event_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setString(1, event.getEventName());
            pStatement.setDate(2, (java.sql.Date) event.getEventDate());
            pStatement.setInt(3, event.getEventCost());
            pStatement.setInt(4, event.getEventId());
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
            query = "DELETE FROM events WHERE event_id = ?";
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
    public Event get(int id) {
        Event event = new Event();
        try {
            getConnection();
            query = "SELECT * From events where event_id = ?";
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, id);
            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                String eventName = resultSet.getString("event_name");
                Date eventDate = resultSet.getDate("event_date");
                int eventCost = resultSet.getInt("event_cost");

                event.setEventId(id);
                event.setEventName(eventName);
                event.setEventDate(eventDate);
                event.setEventCost(eventCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeStatementAndConnection(pStatement, connection);
        }
        return event;
    }
}
