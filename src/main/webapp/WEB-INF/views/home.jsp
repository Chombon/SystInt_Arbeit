<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Flugzeug Lokalisieurung</title>
		<h1>Flight</h1>
		
	</head>
	<body>
		<div id="bloc_page">
			<section>
				<article>
					
						<h3>Notfall</h3>
							
								<p>
									<%@ page import="java.util.ArrayList"%>
									<%@ page import="com.systemintegration.beans.Flug"%>
									
								
									<% ArrayList<Flug> list1=(ArrayList<Flug>) request.getSession().getAttribute("notfall"); 
									if(!list1.isEmpty()){%>
								<form method="post" modelAttribute="home1"  action="zustand.html">
								   <SELECT  size="10" name="fhlightCode">
								   <ul>
								   <% for(Flug i: list1){%>
									 <li>  <OPTION style="color:red;" value="hilfe"><%out.println(i.getFlightcode()); %></OPTION> </li> 
								   	   <%}%>
								   	</ul>
							  	 </SELECT>
							   </form>
							 		<%}else %><tr>Keine Flug in dieser Fall</tr>
								   
								
								</p>
													
				</article>		
			
				<article>
					
						<h3>Im Land Brandenburg </h3>
						
							<form method="post" modelAttribute="home1"  action="zustand.html">
								<p>
								<% ArrayList<String> list2=(ArrayList<String>) request.getSession().getAttribute("inLB"); 
									if(!list2.isEmpty()){%>
								
								   <SELECT  size="10" name="fhlightCode">
								   <ul>
									   <% for(String i: list2){%>
									    <li> <OPTION style="color:green;" value="Bdb"><%out.println(i); %></OPTION> </li> 
									   	<%}%> 
								 	</ul>
								   </SELECT>
								  </form>								  
							 	<%}else %><tr>Keine Flug in dieser Fall</tr>
								   
								
								</p>
							
						
						
									
				</article>		
			
			
				<article>
					<h3>Andere Flüge</h3>
						<p>
								<% ArrayList<Flug> list3=(ArrayList<Flug>) request.getSession().getAttribute("ziel"); 
									if (!list3.isEmpty()){%>
								
									<form method="post" modelAttribute="home1"  action="zustand.html">
										
											
										 <h4>Flight Code | Latitude | Longitude</h4>
										
								
										   <SELECT  size="10" name="fhlightCode">
										   <ul>
										  <% for(Flug i: list3){%>
										<li> <OPTION value="gut">  <%out.println(i.getFlightcode()+" | "+i.getCodes().getLatitude()+" | "+i.getCodes().getLongitude()); %>
										 			
										  </OPTION></li>
										   	</ul>      
										   	<%}%>
										   </SELECT>
									</form>
								   
							 		<%}else %>Keine Flug in dieser Fall
								   
								
								</p>
							
					
						
									
				</article>		
			
			


			</section>
			
		</div>

		
		<P>  The time on the server is ${serverTime}. </P>
	</body>
	<footer id="contact">
	
	</footer>
</html>
