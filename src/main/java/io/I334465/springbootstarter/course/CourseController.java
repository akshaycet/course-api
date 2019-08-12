package io.I334465.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.I334465.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String topicId, @PathVariable String courseId) {
		return courseService.getCourse(topicId, courseId);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId,""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId,""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String topicId, @PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}
}
