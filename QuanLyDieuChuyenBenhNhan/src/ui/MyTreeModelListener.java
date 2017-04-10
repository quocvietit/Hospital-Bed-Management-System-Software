package ui;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class MyTreeModelListener implements TreeModelListener {

	@Override
	public void treeNodesChanged(TreeModelEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) arg0.getTreePath().getLastPathComponent();
		try{
			int index = arg0.getChildIndices()[0];
			node = (DefaultMutableTreeNode) node.getChildAt(index);
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("New value: "+node.getUserObject());
		}
	}

	@Override
	public void treeNodesInserted(TreeModelEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeNodesRemoved(TreeModelEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void treeStructureChanged(TreeModelEvent arg0) {
		// TODO Auto-generated method stub

	}

}
