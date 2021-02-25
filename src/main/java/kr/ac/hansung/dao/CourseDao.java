package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		
		String sqlStatement="select count(*) from offers";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	//query and return a single object
	public Course getCourse(String name) {
		String sqlStatement="select year,semester,sum(point) from courses group by year,semester";
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, 
				new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setType(rs.getString("type"));
				course.setProfessor(rs.getString("professor"));
				course.setPoint(rs.getInt("point"));
				
				return course;
			}
				
	});
		
	}
	
	public List<Course> getCourses() {
		String sqlStatement="select year,semester,sum(point) as point from courses group by year,semester";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setPoint(rs.getInt("point"));
				
				return course;
			}
				
	});
		
	}
	
	public List<Course> getSemesters(Course course) {
		int year=course.getYear();
		int semester=course.getSemester();
		String sqlStatement="select * from courses where year="+year+" and semester="+semester;
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setType(rs.getString("type"));
				course.setProfessor(rs.getString("professor"));
				course.setPoint(rs.getInt("point"));
				return course;
			}
				
	});
		
	}
	
	//Crud method
	public boolean insert(Course course) {
		
		int year=course.getYear();
		int semester=course.getSemester();
		String title=course.getTitle();
		String type=course.getType();
		String professor=course.getProfessor();
		int point=course.getPoint();
		
		String sqlStatement="insert into courses (year, semester, title, type, professor, point) values (?,?,?,?,?,?)";
		
		return (jdbcTemplate.update(sqlStatement, new Object [] {year,semester,title,type,professor,point})==1);
		
	}
	
	//crUd method
	public boolean update(Course course) {
		
		int year=course.getYear();
		int semester=course.getSemester();
		String title=course.getTitle();
		String type=course.getType();
		String professor=course.getProfessor();
		int point=course.getPoint();
		
		String sqlStatement="update offers set name=?, email=?, text=? where id=?";
		
		return (jdbcTemplate.update(sqlStatement, new Object [] {year,semester,title,type,professor,point})==1);
		
	}
	
	//cruD method
	public boolean delete(int title) {
		String sqlStatement="delete from offers where id=?";
		return (jdbcTemplate.update(sqlStatement, new Object[] {title}) ==1);
	}

	public List<Course> courselist() {
		String sqlStatement="select * from courses where year="+2021+" and semester="+1;
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setTitle(rs.getString("title"));
				course.setType(rs.getString("type"));
				course.setProfessor(rs.getString("professor"));
				course.setPoint(rs.getInt("point"));
				return course;
			}
				
	});
	}

}
