package com.model;


	import org.hibernate.SessionFactory;
	import org.hibernate.boot.Metadata;
	import org.hibernate.boot.MetadataSources;
	import org.hibernate.boot.registry.StandardServiceRegistry;
	import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


	public class HibernateUtil {
	public static StandardServiceRegistry sr;
	public static SessionFactory sesFactory;
	public static SessionFactory getSesFactory()
	{
		if(sesFactory==null)
		{
			try
			{
				sr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				MetadataSources sources=new MetadataSources(sr);
				Metadata metadata=sources.getMetadataBuilder().build();
				sesFactory = metadata.getSessionFactoryBuilder().build();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				if(sr!=null)
				
					StandardServiceRegistryBuilder.destroy(sr);	
			}
	}
		return sesFactory;
	}	
	}