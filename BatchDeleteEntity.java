// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package importexport.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class BatchDeleteEntity extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String EntityName;

	public BatchDeleteEntity(IContext context, java.lang.String EntityName)
	{
		super(context);
		this.EntityName = EntityName;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
        final IContext context = this.getContext();
        final Map<String, String> sortOrder = new HashMap<String, String>();

        Core.getLogger("BatchDeleteEntity").info("Batch Deleting entity " + EntityName);
        List<IMendixObject> objectList = Core.retrieveXPathQueryEscaped(context, "//%s", 0, 0, sortOrder, 0, EntityName);
        boolean result = false;
        if (objectList != null && !objectList.isEmpty()) {
            Core.getLogger("BatchDeleteEntity").info("Batch Deleting "+objectList.size()+" rows.");
            result = Core.delete(context, objectList);
        } else {
            Core.getLogger("BatchDeleteEntity").info("No found any rows to delete (" + (objectList==null?"null":"not null") + "," + objectList.size() + "," + objectList.isEmpty() + ").");
        	result = true;
        }

        this.addRefreshClass(EntityName);
        Core.getLogger("BatchDeleteEntity").info("Batch Deleted entity " + EntityName);
        return result;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "BatchDeleteEntity";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
