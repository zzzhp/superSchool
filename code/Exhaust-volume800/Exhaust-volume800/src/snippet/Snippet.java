package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:mvc="http://www.springframework.org/schema/mvc"
		xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
			http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
			http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">
	 	<!-- 自动扫描且只扫描@Controller -->
	 	<context:component-scan base-package="com.controller" use-default-filters="false">
	 		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
	 	</context:component-scan>
	 	
	 	<!-- 拦截器 -->
	    <mvc:interceptors>
	    	<mvc:interceptor>
	            <mvc:mapping path="/**" />
	            <bean class="com.interceptor.SessionInterceptor">
	            </bean>
	        </mvc:interceptor>
	        
	        <mvc:interceptor>
	            <mvc:mapping path="/**" />
	            <bean class="com.interceptor.UserSecurityInterceptor">
	                <property name="excludedUrls">
	                    <list>
	                    	<value>/teacher</value>
	                    </list>
	                </property>
	            </bean>
	        </mvc:interceptor>
	        <mvc:interceptor>
	            <mvc:mapping path="/**" />
	            <bean class="com.interceptor.PowerInterceptor">
	                <property name="jiaoshiUrls">
	                    <list>
	                    	<value>/question</value>
	                    	<value>/exam</value>
	                    	<value>/teacher</value>
	                    	<value>/choose</value>
	                    	<value>/test</value>
	                    	<value>/message</value>
	                    	<value>/Teachermanage</value>
	                    </list>
	                </property>
	                <property name="jiaowuUrls">
	                	<list>
	                		<value>/course</value>
	                		<value>/chapter</value>
	                		<value>/teacher</value>
	                		<value>/recorder</value>
	                		<value>/Teachermanage</value>
	                		<value>/exam</value>
	                		<value>/message</value>
	                	</list>
	                </property>
	            </bean>
	        </mvc:interceptor>
	    
	    
	        
	    </mvc:interceptors>
	 	
	 	
	 	<mvc:annotation-driven/>
	 	<!-- 将无法mapping到Controller的path交给default servlet handler处理 -->	
	 	<mvc:default-servlet-handler/>
	 	<mvc:resources location="/static" mapping="/static/**"/>
	 	
	 	
	 	
	 	<!-- 定义JSP文件的位置 -->
	 	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	 		<property name="prefix" value="/"/>
	 		<property name="suffix" value=".jsp"/>
	 	</bean>
	 	
	 	<bean id="multipartResolver"
	      class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	      		<!-- 默认编码 -->
	          	<property name="defaultEncoding" value="utf-8" />
	          	<!-- 文件大小最大值 -->
	          	<property name="maxUploadSize" value="10485760000" />
	          	<!-- 内存中的最大值 -->
	          	<property name="maxInMemorySize" value="40960" />
		</bean>
	 </beans>
}

