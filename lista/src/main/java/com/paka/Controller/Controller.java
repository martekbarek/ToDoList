package com.paka.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.ui.Model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.paka.Entity.Task;

@org.springframework.stereotype.Controller
public class Controller {

	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
	}
	
	
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
	public ModelAndView createTask(
			@Valid @ModelAttribute("task") Task theTask, BindingResult theBindingResult) {
		
		
		ModelAndView mv = new ModelAndView();
		
		if (theBindingResult.hasErrors()) {
			
				mv.setViewName("createTask");
			return mv;
		} 
		else {
			mv.setViewName("allTasks");
		}
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			System.out.println("Creating new task");
			
			session.save(theTask);

			List<Task> tasks= session.createQuery("from Task").getResultList();
			mv.addObject("tasks", tasks);
			session.getTransaction().commit();
			
		} finally {
			factory.close();	
		}
		
		
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
			
			}
		
		finally {
			
			factory.close();
			
			}
		
		mv.setViewName("allTasks");
		
		return mv;
	}
	
	
	@RequestMapping("editTask")
	public ModelAndView edit(@RequestParam("id") int id,HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Task task = session.get(Task.class, id);
			
		
			session.getTransaction().commit();
			System.out.println("Done");
			mv.addObject("task", task);
		} finally {
			
			factory.close();
			
		}
		
		mv.setViewName("editTask");
		
		return mv;
	}
	
	/*
	@RequestMapping("edit")
public ModelAndView edit(@RequestParam("id") int id,@RequestParam("content") String content,@RequestParam("data") int data,HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView();
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
		
			session.createQuery("update Task set content= '"+content+"' where id=" + id).executeUpdate();
			session.createQuery("update Task set data= '"+data+"' where id=" + id).executeUpdate();

			List<Task> tasks= session.createQuery("from Task").getResultList();
			mv.addObject("tasks", tasks);
			session.getTransaction().commit();
			
		} finally {
			
			
			factory.close();
			
		}
		
		
		mv.setViewName("allTasks");
	   
		
		return mv;
	}
	
	*/
	@RequestMapping("/edit")
	public ModelAndView edit(
			@Valid @ModelAttribute("task") Task theTask, BindingResult theBindingResult) {
		
		
		ModelAndView mv = new ModelAndView();
		
		if (theBindingResult.hasErrors()) {
			
				mv.setViewName("editTask");
			return mv;
		} 
		else {
			mv.setViewName("allTasks");
		}
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Task.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
		
			session.createQuery("update Task set content= '"+theTask.getContent()+"' where id=" + theTask.getId()).executeUpdate();
			session.createQuery("update Task set data= '"+theTask.getData()+"' where id=" + theTask.getId()).executeUpdate();

			List<Task> tasks= session.createQuery("from Task").getResultList();
			mv.addObject("tasks", tasks);
			session.getTransaction().commit();
			
		} finally {
			
			
			factory.close();
			
		}
		
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("createTask")
	public ModelAndView create(	 @ModelAttribute("task") Task theTask, BindingResult theBindingResult) 
 {
		
		ModelAndView mv = new ModelAndView();
			
		mv.setViewName("createTask");
		
		return mv;
	}
	
}
