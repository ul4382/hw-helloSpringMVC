package kr.ac.hansung.model;



import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	
	private int year;
	
	private int semester;
	@NotEmpty(message="The title cannot be empty")
	private String title;
	
	private String type;
	
	private String professor;
	
	private int point;

}
