package com.aplazo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplazo.entity.Credit;
import com.aplazo.entity.Plazo;
import com.aplazo.entity.Task;

@Service
public class TaskService implements ITaskService {
	
	@Autowired
	private ITaskDao taskDao;
	
	public List<Plazo> getTask(Credit credit) {
		
		double monto = credit.getAmount();
		double plazos = credit.getTerms();
		double interes = credit.getRate();
		double montoTotal;
		double amountPlazo;
		int a;
	    		
		montoTotal = monto + (monto*(interes/100));
		amountPlazo = montoTotal/plazos;
		
		List<Plazo> lista = new ArrayList<Plazo>();
		List<Credit> lista2 = new ArrayList<Credit>();
						
		for(a=1 ; a<=plazos;a++) {
			
		    Plazo plazo = new Plazo();
		
			Calendar cal = Calendar.getInstance();
			cal.add( Calendar.DATE, (a*7) );
						
			plazo.setAmount(amountPlazo);
			plazo.setPaymentNumber(a);
			plazo.setPayDate(cal.getTime());
			lista.add(plazo);

		}
	
		lista2.add(credit);
		JSONArray jsArray = new JSONArray(lista);
		JSONArray jsArray2 = new JSONArray(lista2);
		
		Date date2 = new Date();
		
		Task tarea = new Task();
		tarea.setRequestDate(date2);
		
		
		tarea.setInput(jsArray2.toString());
	
		tarea.setOutput(jsArray.toString());
			
		try{
	        taskDao.save(tarea);

		}catch (Exception e) {
			System.out.println("No fue posible guardar el JSON");
			// TODO: handle exception
		}
		
		return lista;
	}
}
