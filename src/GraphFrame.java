import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphFrame extends JFrame {

    private GraphControl graphControl;

    public GraphFrame() {
        super("Graph");

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        ArrayList<String> used = new ArrayList<>();
        ArrayList<String> used2 = new ArrayList<>();
        ArrayList<Object> usedObject = new ArrayList<>();
        ArrayList<Object> usedObject2 = new ArrayList<>();
        int y =0;
        for (int i = 0; i < Main.stringOne.size(); i++) {
            try {
                if (!used.contains(Main.stringOne.get(i))) {
                    Object v1 = graph.insertVertex(parent, null, Main.stringOne.get(i), 20, y, 120,
                            20);
                    y=y+20;
                    used.add(Main.stringOne.get(i));
                    usedObject.add(v1);
                /*mxCell v3 = (mxCell) graph.insertVertex(e1, null, "v3", -0.5, 0,
                        40, 40, "shape=triangle");
                v3.getGeometry().setRelative(true);
                v3.getGeometry().setOffset(new mxPoint(-20, -20));*/
                }
            } finally {
                graph.getModel().endUpdate();
            }
        }
        y=0;
        for (int i = 0; i < Main.stringTwo.size(); i++) {
            try {
                if (!used2.contains(Main.stringTwo.get(i))) {
                    Object v2 = graph.insertVertex(parent, null, Main.stringTwo.get(i), 200, y,
                            200, 20);
                    y=y+20;
                    used2.add(Main.stringTwo.get(i));
                    usedObject2.add(v2);
                }
            } finally {
                graph.getModel().endUpdate();
            }
        }
        for(int i=0; i<Main.stringOne.size(); i++){
            Object v1 = usedObject.get(used.indexOf(Main.stringOne.get(i)));
            Object v2 = usedObject2.get(used2.indexOf(Main.stringTwo.get(i)));
            graph.insertEdge(parent, null, "Edge", v1, v2);

        }

        System.out.println(used.size());
        System.out.println(used2.size());
        graphControl = new GraphControl(graph);
        JScrollPane scrollPane = new JScrollPane(graphControl);
        scrollPane.setAutoscrolls(true);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setSize(new Dimension(320, 200));
    }
}
