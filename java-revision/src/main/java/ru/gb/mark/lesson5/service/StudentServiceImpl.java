package ru.gb.mark.lesson5.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.gb.mark.lesson5.config.Config;
import ru.gb.mark.lesson5.entity.Student;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {


    @Override
    public Optional<Student> getById(Long id) {
        Session session = Config.getSession().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return Optional.of(student);
    }

    @Override
    public void removeById(Long id) {
        Session session = Config.getSession().openSession();
        session.beginTransaction();
        Optional<Student> student = getById(id);
        session.remove(student.orElseThrow());
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Student student) {
        Session session = Config.getSession().openSession();
        session.beginTransaction();
        session.remove(student);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Student> getAll() {
        Session session = Config.getSession().openSession();
        Query<Student> fromStudent = session.createQuery("from Student");
        return fromStudent.getResultList();
    }

    @Override
    public void saveOrUpdate(Student student) {

        Session session = Config.getSession().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(student);
        session.getTransaction().commit();

    }

    @Override
    public void saveAll(List<Student> students) {
        Session session = Config.getSession().openSession();
        session.setJdbcBatchSize(50);
        session.getTransaction().begin();

        for (int i = 0; i < students.size(); i++) {
            session.persist(students.get(i));
            if (i % session.getJdbcBatchSize() == 0) {
                session.flush();
                session.clear();
            }
        }

        session.getTransaction().commit();
    }
}
