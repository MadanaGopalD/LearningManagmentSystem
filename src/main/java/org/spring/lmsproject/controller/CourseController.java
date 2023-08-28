package org.spring.lmsproject.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.spring.lmsproject.config.dto.LessonCountDto;
import org.spring.lmsproject.entity.Course;
import org.spring.lmsproject.entity.Instructor;
import org.spring.lmsproject.entity.Lesson;
import org.spring.lmsproject.service.CourseService;
import org.spring.lmsproject.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("lessonCount")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private InstructorService instructorService;

	private void printPageDetails(PagedListHolder<Lesson> pagedListHolder) {
		System.out.println(pagedListHolder.getPage());// page no
		System.out.println(pagedListHolder.getPageSize());// current page size
		System.out.println(pagedListHolder.isFirstPage());// check if it is first page
		System.out.println(pagedListHolder.isLastPage());// checks if it is the last page
	}

	@RequestMapping("/viewCourse")
	public String viewCourse(@RequestParam(name = "courseId") int id,
			@RequestParam(name = "pageNum", required = false) String page, HttpServletRequest request, Model model) {

		PagedListHolder<Lesson> pagedListHolder = new PagedListHolder<>();
		Course course = null;
		pagedListHolder.setPageSize(2);
		if (page == null || page.equals("0")) {
			course = courseService.findCourseById(id);
			List<Lesson> lessons = course.getLessons();
			pagedListHolder.setSource(lessons);
			pagedListHolder.setPage(0);
			HttpSession session = request.getSession();
			session.setAttribute("pagedListHolder", pagedListHolder);
			session.setAttribute("course", course);
		} else if (page.equals("prev")) {
			HttpSession session = request.getSession();
			pagedListHolder = (PagedListHolder<Lesson>) session.getAttribute("pagedListHolder");
			pagedListHolder.previousPage();
		} else if (page.equals("next")) {
			HttpSession session = request.getSession();
			pagedListHolder = (PagedListHolder<Lesson>) session.getAttribute("pagedListHolder");
			pagedListHolder.nextPage();
		} else {
			HttpSession session = request.getSession();
			pagedListHolder = (PagedListHolder<Lesson>) session.getAttribute("pagedListHolder");
			pagedListHolder.setPage(Integer.parseInt(page));
		}
		course = (Course) request.getSession().getAttribute("course");
		if (course.getLessons().size() > 0) {
			int firstLessonNumber = course.getLessons().get(0).getLessons_id();
			int lastLessonNumber = (firstLessonNumber + course.getLessons().size()) - 1;
			LessonCountDto lessonDto = new LessonCountDto();
			lessonDto.setFirstLessonNumber(firstLessonNumber);
			lessonDto.setLastLessonNumber(lastLessonNumber);
			model.addAttribute("lessonCount", lessonDto);
			return "course-page";
		} else {
			return "course-page";
		}
	}

	@GetMapping("/openLesson")
	public String viewLessons(@RequestParam(name = "id") int lessonId, Model model) {
		Lesson lesson = courseService.findLessonById(lessonId);
		model.addAttribute("lesson", lesson);
		return "lessons-page";
	}

	@GetMapping("/addCourse")
	public String addCoursePage(Model model) {
		List<Instructor> instructors = instructorService.findAllInstructor();
		model.addAttribute("instructors", instructors);
		model.addAttribute("course", new Course());
		return "add-course";
	}

	@PostMapping("/addCourse")
	public String addCourse(Course course) {
		courseService.addCourse(course);
		return "redirect:/home";
	}

	@GetMapping("/addLesson")
	public String addLessonPage(@RequestParam(name = "lessonId", required = false) Integer lessonId, Model model,
			HttpServletRequest request) {
		if (lessonId != null) {
			Course course = (Course) request.getSession().getAttribute("course");
			List<Lesson> lessons = course.getLessons().stream().filter((p) -> p.getLessons_id() == lessonId)
					.collect(Collectors.toList());
			if (!lessons.isEmpty()) {
				model.addAttribute("lesson", lessons.get(0));
			}
		} else {
			model.addAttribute("lesson", new Lesson());
		}
		return "add-lesson";
	}

	@PostMapping("/addLesson")
	public String addLesson(Lesson lesson, Model model, HttpServletRequest request) {
		Course course = (Course) request.getSession().getAttribute("course");
		lesson.setCourse(course);
		System.out.println(lesson);
		courseService.addLesson(lesson);
		return "redirect:/viewCourse?courseId=" + course.getCourse_id();
	}
}
