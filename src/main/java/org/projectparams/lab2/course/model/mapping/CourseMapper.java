package org.projectparams.lab2.course.model.mapping;

import jakarta.annotation.Nullable;
import org.mapstruct.Mapper;
import org.projectparams.lab2.course.article.model.dto.ArticlePreviewDTO;
import org.projectparams.lab2.course.article.model.mapping.ArticleMapper;
import org.projectparams.lab2.course.model.dto.GetCourseDTO;
import org.projectparams.lab2.course.model.entities.Course;
import org.projectparams.lab2.course.test.model.dto.TestPreviewDTO;
import org.projectparams.lab2.course.test.model.mapping.TestMapper;
import org.projectparams.lab2.users.model.dto.UserPreviewDTO;
import org.projectparams.lab2.users.model.entities.Student;
import org.projectparams.lab2.users.model.entities.User;
import org.projectparams.lab2.users.model.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@SuppressWarnings("all")
public abstract class CourseMapper {

    @Autowired
    protected UserMapper userMapper;

    @Autowired
    protected ArticleMapper articleMapper;

    @Autowired
    protected TestMapper testMapper;

    public GetCourseDTO toGetDTO(Course course, @Nullable User forUser) {
        if (course == null) {
            return null;
        }
        UserPreviewDTO[] students = null;
        if (course.getStudents() != null) {
            students = course.getStudents().stream()
                    .map(userMapper::toPreviewDTO).toArray(UserPreviewDTO[]::new);
        }
        TestPreviewDTO[] tests = null;
        if (course.getTests() != null) {
            tests = course.getTests().stream().map(test -> testMapper.toPreviewDTO(
                    test,
                    forUser == null || !(forUser instanceof Student) ? null
                            : ((Student) forUser).getAttempts().stream().anyMatch(att ->
                            att.getTest().getId().equals(test.getId())
                    )
            )).toArray(TestPreviewDTO[]::new);
        }
        UserPreviewDTO[] teachers = null;
        if (course.getTeachers() != null) {
            teachers = course.getTeachers().stream()
                    .map(userMapper::toPreviewDTO).toArray(UserPreviewDTO[]::new);
        }
        ArticlePreviewDTO[] articles = null;
        if (course.getArticles() != null) {
            articles = course.getArticles().stream()
                    .map(articleMapper::toPreviewDTO).toArray(ArticlePreviewDTO[]::new);
        }
        return new GetCourseDTO(course.getId(), course.getName(), tests, articles, students, teachers);
    }
}
