// %1126721330416:hoplugins.transfers.ui.model%
package module.transfer.history;

import core.model.HOVerwaltung;
import module.transfer.PlayerTransfer;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;



/**
 * TableModel representing transfers for a player.
 *
 * @author <a href=mailto:nethyperon@users.sourceforge.net>Boy van der Werf</a>
 */
class PlayerTransferTableModel extends AbstractTableModel {
    //~ Static fields/initializers -----------------------------------------------------------------

    /**
	 *
	 */
	private static final long serialVersionUID = -3205025253995412306L;

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$

    //~ Instance fields ----------------------------------------------------------------------------

    private List<PlayerTransfer> values;
    private String[] colNames = new String[9];

    //~ Constructors -------------------------------------------------------------------------------

    /**
     * Creates a PlayerTransferTableModel.
     *
     * @param values List of values to show in table.
     */
    PlayerTransferTableModel(List<PlayerTransfer> values) {
        super();

        this.colNames[0] = HOVerwaltung.instance().getLanguageString("Datum"); //$NON-NLS-1$
        this.colNames[1] = HOVerwaltung.instance().getLanguageString("Season"); //$NON-NLS-1$
        this.colNames[2] = HOVerwaltung.instance().getLanguageString("Week"); //$NON-NLS-1$
        this.colNames[3] = HOVerwaltung.instance().getLanguageString("Buyer"); //$NON-NLS-1$
        this.colNames[4] = ""; //$NON-NLS-1$
        this.colNames[5] = HOVerwaltung.instance().getLanguageString("Seller"); //$NON-NLS-1$
        this.colNames[6] = HOVerwaltung.instance().getLanguageString("Price"); //$NON-NLS-1$
        this.colNames[7] = HOVerwaltung.instance().getLanguageString("ls.player.tsi"); //$NON-NLS-1$
        this.colNames[8] = ""; //$NON-NLS-1$

        this.values = values;
    }

    //~ Methods ------------------------------------------------------------------------------------

    /** {@inheritDoc} */
    public final int getColumnCount() {
        return colNames.length;
    }

    /** {@inheritDoc} */
    @Override
	public final String getColumnName(int column) {
        return colNames[column];
    }

    /** {@inheritDoc} */
    public final int getRowCount() {
        return values.size();
    }

    /** {@inheritDoc} */
	public boolean isCellEditable(int row, int col) {
        return col == 8;
    }

    /** {@inheritDoc} */
    public final Object getValueAt(int rowIndex, int columnIndex) {
        final PlayerTransfer transfer = values.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> transfer.getDate().toLocaleDateTime();
            case 1 -> transfer.getSeason();
            case 2 -> transfer.getWeek();
            case 3 -> transfer.getBuyerName();
            case 4 -> PlayerTransfer.BUY;
            case 5 -> transfer.getSellerName();
            case 6 -> transfer.getPrice();
            case 7 -> transfer.getTsi();
            case 8 -> new JButton(HOVerwaltung.instance().getLanguageString("ls.button.delete"));
            default -> ""; //$NON-NLS-1$
        };
    }
}
