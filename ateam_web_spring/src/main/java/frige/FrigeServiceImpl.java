package frige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrigeServiceImpl implements FrigeService {
	@Autowired private FrigeDAO dao;
	
}
