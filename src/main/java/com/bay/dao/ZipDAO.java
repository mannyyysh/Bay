/**
 * 
 */
package com.bay.dao;

import java.util.List;

import com.bay.domain.Zip;

/**
 * @author aagarwal
 *
 */
public interface ZipDAO {

	public List<Zip> findZips(String zipcode, Double radius);
}
