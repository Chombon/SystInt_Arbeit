package com.systemintegration.projekt;

import com.systemintegration.beans.ModelVO;

public class MainController {
private ModelVO _Model = null;
	
	/**
	 * Constructor
	 * @param view the view, which will be shown
	 */
	public MainController( ModelVO model) {
		set_Model(model);
		
	}

	public ModelVO get_Model() {
		return _Model;
	}

	public void set_Model(ModelVO _Model) {
		this._Model = _Model;
	}
}
