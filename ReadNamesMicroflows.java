// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package mendix.actions;

import java.util.List;
import mendix.proxies.Microflow;
import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

public class ReadNamesMicroflows extends CustomJavaAction<java.lang.Boolean>
{
	public ReadNamesMicroflows(IContext context)
	{
		super(context);
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		removeAll(Microflow.getType());
		
		for(String nf : Core.getMicroflowNames()){
			
			Microflow flow = new Microflow(getContext());
			flow.setName(nf);			
			Core.commit(getContext(), flow.getMendixObject());
		}
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "ReadNamesMicroflows";
	}

	// BEGIN EXTRA CODE
	public void removeAll(String type) throws CoreException {
		List<IMendixObject> objs = Core.retrieveXPathQuery(getContext(), "//" + type);
		for(IMendixObject obj : objs)
			Core.delete(getContext(), obj);
			
	}
	// END EXTRA CODE
}
