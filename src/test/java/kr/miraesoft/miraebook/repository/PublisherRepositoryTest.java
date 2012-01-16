package kr.miraesoft.miraebook.repository;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import kr.miraesoft.miraebook.domain.Publisher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})
public class PublisherRepositoryTest {

	@Autowired PublisherRepository publisherRepository;
	
	@Test
	public void ���ǼҸ�_����մϴ�() throws Exception {
		//begin
		Publisher publisher = new Publisher();
		publisher.setId(1L);
		publisher.setName("�Ѻ��̵��");
		
		//when
		publisherRepository.save(publisher);
		
		//begin
		publisher = new Publisher();
		publisher.setId(2L);
		publisher.setName("�λ���Ʈ");
		
		//when
		publisherRepository.save(publisher);
		
		//then.
		assertEquals(publisherRepository.findAll().size(), 2);
	}
	
	@Test
	public void ���ǼҸ�_�����մϴ�() throws Exception {
		//begin
		Publisher publisher = publisherRepository.findOne(1L);
		publisher.setName("����");
		
		//when
		publisherRepository.save(publisher);
		publisher = publisherRepository.findOne(1L);
		
		//then
		assertEquals(publisher.getName(), "����");
		
	}
	
	
	@Test
	public void ���ǼҸ�_�����մϴ�() throws Exception {
		//begin
		Publisher publisher = publisherRepository.findOne(2L);
		
		//when
		publisherRepository.delete(2L);
		publisher = publisherRepository.findOne(2L);
		
		//then
		assertNull(publisher);
			
	}
}