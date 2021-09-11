package com.aplazo;

import java.util.List;
import com.aplazo.entity.Credit;
import com.aplazo.entity.Plazo;

public interface ITaskService {

	public List<Plazo> getTask(Credit credit);
	
}