package kr.miraesoft.miraebook.repository;
import static org.junit.Assert.*;
import kr.miraesoft.miraebook.domain.Location;
import kr.miraesoft.miraebook.domain.LocationType;
import kr.miraesoft.miraebook.repository.LocationRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class LocationRepositoryTest {

	@Autowired LocationRepository locationRepository;
	
	@Test
	public void å����Ҹ�_����մϴ�() throws Exception {
		//begin
		Location location = new Location();
		location.setId(1L);
		location.setName("����������");
		location.setLocationType(LocationType.IT);
		
		//when
		locationRepository.save(location);
		
		//begin
		location = new Location();
		location.setId(2L);
		location.setName("1Q84");
		location.setLocationType(LocationType.FICTION);
		
		//when
		locationRepository.save(location);
		
		//then.
		assertEquals(locationRepository.findAll().size(), 2);
	}
	
	@Test
	public void å����Ҹ�_�����մϴ�() throws Exception {
		//begin
		Location loc = locationRepository.findOne(1L);
		loc.setName("�������ֵ�����");
		
		//when
		locationRepository.save(loc);
		loc = locationRepository.findOne(1L);
		
		//then
		assertEquals(loc.getName(), "�������ֵ�����");
		
	}
	
	
	@Test
	public void å����Ҹ�_�����մϴ�() throws Exception {
		//begin
		Location loc = locationRepository.findOne(2L);
		
		//when
		
		//then
		assertEquals(loc.getName(), "1Q84");
			
	}
}
