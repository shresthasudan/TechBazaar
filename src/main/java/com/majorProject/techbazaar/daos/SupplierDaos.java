package com.majorProject.techbazaar.daos;

import java.util.List;

import com.majorProject.techbazaar.model.Supplier;

public interface SupplierDaos {
	public void addSupplier(Supplier s);
	public List<Supplier> getAllSupplier();
	public Supplier getSupplier(int id);

}
