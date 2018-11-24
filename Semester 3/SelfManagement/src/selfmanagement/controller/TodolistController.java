/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selfmanagement.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import selfmanagement.model.Account;
import selfmanagement.view.TodolistView;
import selfmanagement.model.Todolist;
import selfmanagement.view.DashboardView;
import selfmanagement.model.Dashboard;
import selfmanagement.model.Notes;
import selfmanagement.model.dao.TodolistDAOImpl;
import selfmanagement.view.HomeView;
import selfmanagement.view.NotesView;
import selfmanagement.view.TodolistFormView;
/**
 *
 * @author user
 */
public class TodolistController implements DefaultMenu {
    private TodolistView todolistView;
    private Todolist todolist;
    private DashboardView dashboardView;
    private Dashboard dashboard;
    private List<Todolist> list;
    private TodolistDAOImpl todolistDAOImpl;
    private TodolistFormView todolistFormView;
    
    int row;
    
    public TodolistController(TodolistView todolistView, Todolist todolist) {
        this.todolist = todolist;
        this.todolistView = todolistView;
        todolistDAOImpl = new TodolistDAOImpl();
        todolistFormView = new TodolistFormView();
        list = todolistDAOImpl.getAllTodolist();
        todoFrame();
    }
    
    public void initTodo() {
        todolistView.getDashboardButton().addActionListener((ae) -> dashboardFrame());
        todolistView.getTodoButton().addActionListener((ae) -> todoFrame());
        todolistView.getNoteButton().addActionListener((ae) -> noteFrame());
        todolistView.getContactButton().addActionListener((ae) -> contactFrame());
        todolistView.getAccountmanagementButton().addActionListener((ae) -> accountManagementFrame());
        todolistView.getAccountButton().addActionListener((ae) -> accountFrame());
        todolistView.getLogoutButton().addActionListener((ae) -> logout());
        todolistView.getAddButton().addActionListener((ae) -> addTodoFrame());
        todolistView.getEditButton().addActionListener((ae) -> editTodoFrame());
        todolistView.getViewButton().addActionListener((ae) -> viewTodoFrame());
        
        todolistView.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deleteTodoFrame();
            }
        });
        
        todolistView.getTodoTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                selectRow();
            }
        });
    }
    
    public void reloadData(List<Todolist> list) {
        try {
            todolistView.getDashboardFrame().dispose();
            todolistView.getDashboardFrame().setVisible(true);
            Object[] kolom = todolistView.getColumnTable();
            DefaultTableModel todoModel = new DefaultTableModel(kolom, 0);
            if(!list.isEmpty() && list != null) {
               // TodolistView todoView = new TodolistView();
                for(Todolist todo : list) {
                    Object[] isi = new Object[3];
                    if(!Boolean.parseBoolean(String.valueOf(todo.getStatus()))) {
                        isi[0] = "Progress";
                    } else {
                        isi[0] = "Done";
                    }
                    isi[1] = todo.getTitle();
                    isi[2] = todo.getSchedule();
//                    todolistView.getTodoModel().addRow(isi);
                    todoModel.addRow(isi);
                }
                todolistView.getTodoTable().setModel(todoModel);
                todolistView.getTodoTable().getColumnModel().getColumn(0).setPreferredWidth(67);
                todolistView.getTodoTable().getColumnModel().getColumn(1).setPreferredWidth(300);
                todolistView.getTodoTable().getColumnModel().getColumn(2).setPreferredWidth(150);
            } else {
                JOptionPane.showMessageDialog(null,"Data belum tersedia!", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch(Exception er) {
            error_log(er);
        }
    }
    
    public void dashboardFrame() {
        try {
            todolistView.getDashboardFrame().dispose();
            dashboardView = new DashboardView();
            dashboard = new Dashboard();
            DashboardController dashboardController = new DashboardController(dashboardView, dashboard);
            dashboardController.initDashboard();
        } catch(Exception er) {
            error_log(er);
        }
    }

    @Override
    public void todoFrame() {
        try {
            todolistView.getDashboardFrame().dispose();
            reloadData(list);
        } catch(Exception er) {
            error_log(er);
        }
    }

    @Override
    public void noteFrame() {
        try {
            todolistView.getDashboardFrame().dispose();
            NotesView notesView = new NotesView();
            Notes notes = new Notes();
            NotesController notesController = new NotesController(notesView, notes);
            notesController.initNotes();
        } catch(Exception er) {
            error_log(er);
        }
    }

    @Override
    public void accountManagementFrame() {
        try {
            
        } catch(Exception er) {
            error_log(er);
        }
    }

    @Override
    public void contactFrame() {
        try {
            
        } catch(Exception er) {
            error_log(er);
        }
    }

    @Override
    public void accountFrame() {
        try {
            
        } catch(Exception er) {
            error_log(er);
        }
    }

    @Override
    public void logout() {
        try {
            int input = JOptionPane.showConfirmDialog(null, "Ingin Logout?","",JOptionPane.YES_NO_OPTION);
            if(input == 0) {
                todolistView.getDashboardFrame().dispose();
                HomeView homeView = new HomeView();
                Account account = new Account();
                LoginController loginController = new LoginController(homeView, account);
                loginController.initLogin();
            } 
        } catch(Exception er) {
            error_log(er);
        }
    }
    
    public void addTodoFrame() {
       try {
           todolistFormView.getTodoFrame().setVisible(true);
           todolistFormView.getSubmitButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   int id = todolist.getIdUser();
                   String title = todolistFormView.getTitleField().getText().trim();
                   String deadline = todolistFormView.getDateEndField().getText().trim();
                   String category = (String) todolistFormView.getCategoryCombo().getSelectedItem();
                   int id_category = todolistFormView.getCategoryCombo().getSelectedIndex()+1;
                   
                   String prioritas = (String) todolistFormView.getPriorityCombo().getSelectedItem();
                   int id_prioritas = todolistFormView.getCategoryCombo().getSelectedIndex();
                   int status = todolistFormView.getStatusCombo().getSelectedIndex();
                   String attachement = "LINK FILE IMAGE HERE";
                   String detail = todolistFormView.getDetailTextArea().getText().trim();
                   
                   todolist.setIdUser(id);
                   todolist.setTitle(title);
                   todolist.setIdCategory(id_category);
                   todolist.setCategoryName(category);
                   todolist.setSchedule(deadline);
                   todolist.setPriorityName(prioritas);
                   todolist.setStatus(status);
                   todolist.setAttachement(attachement);
                   todolist.setDetail(detail);
                   if(todolistDAOImpl.insertTodolist(todolist)) {
                       resetField();
                       JOptionPane.showMessageDialog(null, "Berhasil", "Berhasil menambahkan Todolist", JOptionPane.INFORMATION_MESSAGE);
                       TodolistDAOImpl todo = new TodolistDAOImpl();
                       List<Todolist> data = new ArrayList<Todolist>();
                       data = todo.getAllTodolist();
                       reloadData(data);
                   } else {
                        JOptionPane.showMessageDialog(null, "ERROR", "Gagal Menambahkan Todolist!", JOptionPane.ERROR_MESSAGE);
                   }
               }
           });
           
           
           todolistFormView.getResetButton().addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   resetField();
               }
           });
      } catch(Exception er) {
           error_log(er);
       }
    }
    
    public void editTodoFrame() {
        try {
            todolistFormView.getTodoFrame().setVisible(true);
            
        } catch(Exception er) {
            error_log(er);
        }
    }
    
    public void deleteTodoFrame() {
        try {
//            todolistView.setTodoModel((DefaultTableModel) todolistView.getTodoTable().getModel());
            int input = JOptionPane.showConfirmDialog(null, "Apa Anda Yakin?","",JOptionPane.YES_NO_OPTION);
            if(input == 0) {
                todolistView.setTodoModel((DefaultTableModel) todolistView.getTodoTable().getModel());
                todolistView.getTodoModel().removeRow(row);      
//                todolistDAOImpl.deleteTodolist(todolistView.getTodoTable().get);
                todolistView.getDeleteButton().setEnabled(false);
                JOptionPane.showMessageDialog(null, "Berhasil menghapus data");
            } 
        } catch(Exception er) {
            error_log(er);
        }
    }
   
    public void viewTodoFrame() {
        try {
            todolistFormView.getTodoFrame().setVisible(true);
            
        } catch(Exception er) {
            error_log(er);
        }
    }
    
    public void categoryTodo() {
        try {
            
        } catch(Exception er) {
            error_log(er);
        }
    }
    
    public void selectRow() {
        try {
            row = todolistView.getTodoTable().getSelectedRow();
            todolistView.getDeleteButton().setEnabled(true);
        }catch(Exception er){
            error_log(er);
        }
    }
    
    public void resetField() {
        try {
            todolistFormView.getTitleField().setText("");
            todolistFormView.getDateEndField().setText("");
            todolistFormView.getCategoryCombo().setSelectedItem(null);
            todolistFormView.getPriorityCombo().setSelectedItem(null);
            todolistFormView.getStatusCombo().setSelectedItem(null);
            todolistFormView.getDetailTextArea().setText("");
        } catch(Exception er) {
            error_log(er);
        }
    }
    
    public void error_log(Exception er) {
        er.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR", er.getMessage(), JOptionPane.ERROR_MESSAGE);   
    }
}
