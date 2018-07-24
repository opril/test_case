package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

public class DB {
	public void initAll() {
		try (Session session = HibernateUtil.getSession()) {
        	session.beginTransaction();
        	
        	List<Event> events = new ArrayList<Event>();
        	
        	try{
				File inputF = new File("F:\\My\\Java\\smartsoft\\src\\main\\webapp\\test_case.csv");
				InputStream inputFS = new FileInputStream(inputF);
				BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
				
				events = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
				br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
        	
        	for (Event ev: events) {
        		session.save(ev);
        	}
        	
        	session.getTransaction().commit();
        	session.close();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	private Function<String, Event> mapToItem = (line) -> {
		String[] p = line.split(";");
		
/*		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
		Date date = null;
		try {
			date = dateFormat.parse(p[11]);
		} catch (ParseException e) {
			System.out.println(p[11]);
			e.printStackTrace();
		}
*/
		Event ev = new Event(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9], p[10], p[11]);
		
		return ev;
	};
	
	public List<Event> getUsersAndFormsForLastHour() {
		try (Session session = HibernateUtil.getSession()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
			Date date = new Date();
			String queryDate = dateFormat.format(date);
			
        	TypedQuery<Event> query = session.createQuery("SELECT e FROM Event e WHERE ymdh = '" + queryDate + "'", Event.class);
        	
        	return query.getResultList();
		} catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
	}
	
	public List<Event> getNotFinishedForms() {
		try (Session session = HibernateUtil.getSession()) {
			
        	TypedQuery<Event> query = session.createQuery("SELECT e FROM Event e WHERE not(subtype='send')", Event.class);
        	
        	return query.getResultList();
		} catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
	}
	
	public List<Event> getTopFiveForms() {
		try (Session session = HibernateUtil.getSession()) {
			
        	TypedQuery<Event> query = session.createQuery("SELECT formid FROM Event WHERE not(formid='') and (formid is not null) group by formid order by max(formid)", Event.class).setMaxResults(5);
        	
        	return query.getResultList();
		} catch (Exception ex) {
        	ex.printStackTrace();
        }
		return null;
	}
}
