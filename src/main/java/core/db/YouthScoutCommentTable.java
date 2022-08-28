package core.db;

import core.model.player.CommentType;
import module.youth.YouthPlayer.ScoutComment;
import core.util.HOLogger;
import module.training.Skills;
import tool.hrfExplorer.HrfExplorer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class YouthScoutCommentTable extends AbstractTable {

    /** tablename **/
    final static String TABLENAME = "YOUTHSCOUTCOMMENT";

    YouthScoutCommentTable(JDBCAdapter adapter) {
        super(TABLENAME, adapter);
    }

    @Override
    protected void initColumns() {
        columns = new ColumnDescriptor[]{
                new ColumnDescriptor("YOUTHPLAYER_ID", Types.INTEGER, false),
                new ColumnDescriptor("INDEX", Types.INTEGER, false),
                new ColumnDescriptor("Text", Types.VARCHAR, true, 255),
                new ColumnDescriptor("Type", Types.INTEGER, true),
                new ColumnDescriptor("Variation", Types.INTEGER, true),
                new ColumnDescriptor("SkillType", Types.INTEGER, true),
                new ColumnDescriptor("SkillLevel", Types.INTEGER, true)
        };
    }

    public int countScoutComments(int youthplayerid) {
        var sql = "SELECT count(*) FROM "+getTableName()+" WHERE YOUTHPLAYER_ID=" + youthplayerid;
        var rs = adapter.executeQuery(sql);
        try {
            if (rs != null && rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException sexc) {
            HrfExplorer.appendText("" + sexc);
        }
        return 0;
    }

    public int deleteScoutComments(int youthplayerid) {
        final String[] where = { "YOUTHPLAYER_ID" };
        final String[] values = { "" + youthplayerid };
        return delete(where, values);
    }

    public void storeYouthScoutComment(int i, int youthPlayerId, ScoutComment c) {
        //insert vorbereiten
        String sql = "INSERT INTO " + getTableName() +
                " (YOUTHPLAYER_ID,INDEX,Text,Type,Variation,SkillType,SkillLevel) VALUES(" +
                youthPlayerId + "," +
                i + ",'" +
                DBManager.insertEscapeSequences(c.getText()) + "'," +
                ValueOf(c.getType()) + "," +
                c.getVariation() + "," +
                ValueOf(c.getSkillType()) + "," +
                c.getSkillLevel() +
                ")";
        adapter.executeUpdate(sql);
    }

    private String ValueOf(CommentType type) {
        if (type != null) return "" + type.getValue();
        return null;
    }

    private String ValueOf(Skills.ScoutCommentSkillTypeID skillType) {
        if (skillType != null) return "" + skillType.getValue();
        return "null";
    }

    public List<ScoutComment> loadYouthScoutComments(int youthplayer_id) {
        final ArrayList<ScoutComment> ret = new ArrayList<>();
        if ( youthplayer_id > -1) {
            var sql = "SELECT * from " + getTableName() + " WHERE YOUTHPLAYER_ID = " + youthplayer_id;
            var rs = adapter.executeQuery(sql);
            try {
                if (rs != null) {
                    rs.beforeFirst();
                    while (rs.next()) {
                        var comment = createObject(rs);
                        ret.add(comment);
                    }
                }
            } catch (Exception e) {
                HOLogger.instance().log(getClass(), "DatenbankZugriff.getYouthScoutComments: " + e);
            }
        }
        return ret;
    }

    private ScoutComment createObject(ResultSet rs) {
        ScoutComment ret = new ScoutComment();
        try {
            ret.setYouthPlayerId(rs.getInt("YouthPlayer_Id"));
            ret.setIndex(rs.getInt("Index"));
            ret.setText(DBManager.deleteEscapeSequences(rs.getString("Text")));
            ret.setSkillLevel(rs.getInt("SkillLevel"));
            ret.setSkillType(Skills.ScoutCommentSkillTypeID.valueOf(rs.getInt("SkillType")));
            ret.setVariation(rs.getInt("Variation"));
            ret.setType(CommentType.valueOf(rs.getInt("Type")));
        } catch (Exception e) {
            HOLogger.instance().log(getClass(),e);
        }
        return ret;
    }
}
