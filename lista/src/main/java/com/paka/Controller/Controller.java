package com.paka.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.paka.Entity.Task;
import com.paka.Query.Deletetasks;
import com.paka.Query.createQuery;

@org.springframework.stereotype.Controller
public class Controller {

	
@RequestMapping("/")
	
	public ModelAndView ctrl() {
		
	ModelAndView mv = new ModelAndView();
	
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		try {
			
	
			session.beginTransaction();
			
			List<Task> tasks= session.createQuery("from Task").getResultList();
			mv.addObject("tasks", tasks);
			for (Task tempTask : tasks)
			{
				System.out.println(tempTask+" ");
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		} finally {
			
			factory.close();
			
		}
		
		
		
		
		mv.setViewName("allTasks");
		
		
		return mv;
		
		
	}
	
	
	@RequestMapping("/create")
	public ModelAndView createTask(@RequestParam("content") String content,@RequestParam("data") int data,HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Creating new task");
			
			
			
			
			Task task = new Task();
			
			task.setContent(content);
			task.setData(data);
			
			session.save(task);
			List<Task> tasks= session.createQuery("from Task").getResultList();
			mv.addObject("tasks", tasks);
			session.getTransaction().commit();
			
		} finally {
			
			
			factory.close();
			
		}
		
		
		
		
	
		
		mv.setViewName("allTasks");
		
		
		return mv;
	}
	
	
	@RequestMapping("/deleteTask")
	public ModelAndView deleteTask(@RequestParam("id") int id,HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();

		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();

		
		try {
			
	
			session.beginTransaction();
			session.createQuery("delete Task where id= "+id).executeUpdate();
			List<Task> tasks= session.createQuery("from Task").getResultList();
			mv.addObject("tasks", tasks);
			for (Task tempTask : tasks)
			{
				System.out.println(tempTask+" ");
			}
			
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		} finally {
			
			factory.close();
			
		}
		
		
		mv.setViewName("allTasks");
		
		return mv;
	}
	
	
	public void generate() {
		
		
	}
	
	
	
	
	
	
}
