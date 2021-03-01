package com.majorProject.techbazaar.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.majorProject.techbazaar.model.Report;

public class ProductReportImpl implements ProductReport{

	@Override
	public List<Map<String, ?>> findAll() {
		List<Map<String, ?>> listProducts = new ArrayList<Map<String,?>>();
		ReportDaosImpl productModel = new ReportDaosImpl();
		for(Report r : productModel.findAll()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", r.getId());
			m.put("name", r.getName());
			m.put("price", r.getPrice());
			m.put("quantity", r.getQuantity());
			listProducts.add(m);
			
		}
		return listProducts;
	}

}
