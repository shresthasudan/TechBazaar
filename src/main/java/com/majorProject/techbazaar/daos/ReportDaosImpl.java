package com.majorProject.techbazaar.daos;

import java.util.ArrayList;
import java.util.List;

import com.majorProject.techbazaar.model.Report;

public class ReportDaosImpl implements ReportDaos{

	@Override
	public List<Report> findAll() {
		List<Report> listproducts = new ArrayList<Report>();
		listproducts.add(new Report("p1","Name 1", 5, 1000));
		listproducts.add(new Report("p2","Name 2", 6, 2000));
		listproducts.add(new Report("p3","Name 3", 7, 3000));
		listproducts.add(new Report("p4","Name 4", 8, 4000));
		listproducts.add(new Report("p5","Name 5", 9, 5000));
		return listproducts;
	}

}
