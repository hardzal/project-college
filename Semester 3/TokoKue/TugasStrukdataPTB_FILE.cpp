#include<iostream>
#include<malloc.h> // malloc untuk bahasa c sedangkan new untuk bahasa c++
#include<fstream>
#include<string.h>
#include<string>
using namespace std;
// pewoeder // inorder // postoreder
// implementasi binary search tree
typedef struct {
    int noMhs;
	char nama[100];
	float uts, uas, akhir;
} dataMahasiswa;

typedef struct mahasiswa *nilaiMahasiswa;
struct mahasiswa {
    dataMahasiswa mhs;
	nilaiMahasiswa kiri, kanan;
};

nilaiMahasiswa dataNilai, tempNilai, resultNilai;
ofstream dataMhsBaru;
ifstream dataMhsLama;

void createBST() {
    dataNilai = NULL;
}

int emptyBST() {
    return (dataNilai == NULL ? true : false);
}

void insertNode(dataMahasiswa info) {
    nilaiMahasiswa newNilai;
//    newNilai = (mahasiswa *) malloc(sizeof(mahasiswa));
    newNilai = new mahasiswa;
    newNilai->mhs = info;
    newNilai->kiri = NULL;
    newNilai->kanan = NULL;
    if(emptyBST()) {
        dataNilai = newNilai;
    } else {
        resultNilai = dataNilai;
        tempNilai = dataNilai;
        while(tempNilai != NULL && info.noMhs != tempNilai->mhs.noMhs) {
            resultNilai = tempNilai;
            if(info.noMhs < tempNilai->mhs.noMhs) {
                tempNilai =  resultNilai->kiri;
            } else {
                tempNilai = resultNilai->kanan;
            }
        }
        if(info.noMhs == resultNilai->mhs.noMhs) {
            cout << "Node " << info.noMhs << " sudah ada " << endl;
        } else {
            if(info.noMhs < resultNilai->mhs.noMhs) {
                resultNilai->kiri = newNilai;
            } else {
                resultNilai->kanan = newNilai;
            }
        }
    }
}

void preorder(nilaiMahasiswa nilai) {
    if(nilai != NULL) {
        cout << "NIM\t\t: " << nilai->mhs.noMhs << endl;
        cout << "Nama\t\t: " << nilai->mhs.nama << endl;
        cout << "UTS\t\t: " << nilai->mhs.uts << endl;
        cout << "UAS\t\t: " <<  nilai->mhs.uas << endl;
        cout << "Nilai Akhir\t: " << nilai->mhs.akhir << endl << endl;
        preorder(nilai->kiri);
        preorder(nilai->kanan);
    }
}

void inorder(nilaiMahasiswa nilai) {
    if(nilai != NULL) {
        inorder(nilai->kiri);
        cout << "NIM\t\t: " << nilai->mhs.noMhs << endl;
        cout << "Nama\t\t: " << nilai->mhs.nama << endl;
        cout << "UTS\t\t: " << nilai->mhs.uts << endl;
        cout << "UAS\t\t: " <<  nilai->mhs.uas << endl;
        cout << "Nilai Akhir\t: " << nilai->mhs.akhir << endl << endl;
        inorder(nilai->kanan);
    }
}

void postorder(nilaiMahasiswa nilai) {
    if(nilai != NULL) {
        postorder(nilai->kiri);
        postorder(nilai->kanan);
        cout << "NIM\t\t: " << nilai->mhs.noMhs << endl;
        cout << "Nama\t\t: " << nilai->mhs.nama << endl;
        cout << "UTS\t\t: " << nilai->mhs.uts << endl;
        cout << "UAS\t\t: " <<  nilai->mhs.uas << endl;
        cout << "Nilai Akhir\t: " << nilai->mhs.akhir << endl << endl;
    }
}

void hapus() {
    nilaiMahasiswa temp;
// Bila PTB terdiri dari akar saja atau akar dengan 1 anak kiri/kanan
  if (tempNilai->kiri==NULL && tempNilai->kanan==NULL)
	  {
		 if (resultNilai==dataNilai && tempNilai==dataNilai)
			 dataNilai=NULL;
		 else
			 {
				if (tempNilai==resultNilai->kiri)
					resultNilai->kiri=NULL;
				else
					resultNilai->kanan=NULL;
			 }
		delete tempNilai;
		}
// Bila PTB memiliki anak kiri dan anak kanan dgn banyak anak cabang
  else if (tempNilai->kiri!=NULL && tempNilai->kanan!=NULL)
	  {
		 temp=tempNilai->kiri;
		 resultNilai=tempNilai;
		 while (temp->kanan != NULL)
			{ resultNilai=temp;
			  temp=temp->kanan; }
		 tempNilai->mhs=temp->mhs;
		 if (resultNilai==tempNilai)
			 resultNilai->kiri = temp->kiri;
		 else
			 resultNilai->kanan = temp->kiri;
		 delete temp;
	  }
// Bila PTB memiliki anak kiri saja dgn banyak anak cabang
  else if (tempNilai->kiri!=NULL && tempNilai->kanan==NULL)
	  {
		 if (resultNilai==tempNilai)
			 dataNilai=tempNilai->kiri;
		 else
			{ if (tempNilai==resultNilai->kiri)
				  resultNilai->kiri=tempNilai->kiri;
			  else
				  resultNilai->kanan=tempNilai->kiri;
			}
		 delete tempNilai;
	  }
// Bila PTB memiliki anak kanan saja dgn banyak anak cabang
  else if (tempNilai->kiri==NULL && tempNilai->kanan!=NULL)
	  {
		 if (resultNilai==tempNilai)
			 dataNilai=tempNilai->kanan;
		 else
			{ if (tempNilai==resultNilai->kanan)
				  resultNilai->kanan=tempNilai->kanan;
			  else
				  resultNilai->kiri=tempNilai->kanan;
			}
		 delete tempNilai;
	  }
}

void hapusnode(dataMahasiswa iH)
{
  if (emptyBST())
	  cout << "PTB Kosong !\n\n";
  else
    {
        resultNilai=dataNilai;
        tempNilai=dataNilai;
		// mencari tempat hapus node
		while(tempNilai!=NULL && iH.noMhs!=tempNilai->mhs.noMhs)
        {
            resultNilai = tempNilai;
            if (iH.noMhs < tempNilai->mhs.noMhs) {
                tempNilai=resultNilai->kiri;
            } else {
                tempNilai=resultNilai->kanan;
            }
        }
	 }
    hapus();
}

void updateNode(dataMahasiswa data) {}

void searchNode(dataMahasiswa data) {}

int totalNode(nilaiMahasiswa nilaiMhs) {
 if(nilaiMhs != NULL) {
    return totalNode(nilaiMhs->kiri) + totalNode(nilaiMhs->kanan) + 1;
 }
 return 0;
}

void printNode() {
    char pilih;
    do {
        int total = totalNode(dataNilai);
        if(total) {
            cout << "Total Node\t: " << total << endl;
            cout << "1. Pre-order\n2. In-order\n3. Post-order\nPilih\t: ";
            cin >> pilih;
            switch(pilih) {
                case '1':
                    cout << endl << "Pre-order : " << endl;
                    preorder(dataNilai);
                    break;
                case '2':
                    cout << endl << "In-order : " << endl;
                    inorder(dataNilai);
                    break;
                case '3':
                    cout << endl << "Post-order : " << endl;
                    postorder(dataNilai);
                    break;
                default:
                    cout << "Pilihanmu tidak ada dimenu" << endl;
            }
        } else {
            cout << "Belum ada node" << endl;
        }
        cout << "Ingin kembali ke menu (y/n) ?\t: "; cin >> pilih;
        if(pilih == 'n'|| pilih=='N') break;
     } while(true);
    return;
}

void readData() {
    dataMhsLama.open("dataMahasiswa.txt", ios::binary);
    dataMahasiswa mahasiswaLama;
    if(!dataMhsLama.fail()) {
        while(dataMhsLama.read((char *) &mahasiswaLama, sizeof(mahasiswaLama))) {
            insertNode(mahasiswaLama);
        }
        dataMhsLama.close();
    }
}

void insertData(dataMahasiswa tempMahasiswa) {
    dataMhsBaru.open("dataMahasiswa.txt", ios::binary|ios::app);
    if(dataMhsBaru.is_open()) {
        dataMhsBaru.write((char *) &tempMahasiswa, sizeof(tempMahasiswa));
        dataMhsBaru.close();
    } else {
        cout << "Gagal menyimpan kedalam file" << endl;
    }
}

void searchData(dataMahasiswa mhs) {
    bool find = false;
    dataMahasiswa dataMhs;
    ifstream readFile;
    readFile.open("dataMahasiswa.txt", ios::binary);
    while(readFile.read((char *) &dataMhs, sizeof(dataMhs))) {
        if(mhs.noMhs == dataMhs.noMhs) {
            find = true;
            break;
        }
    }
    if(find) {
        cout << "Mahasiswa dengan NIM " << mhs.noMhs << " ditemukan" << endl;
    } else {
        cout << "Mahasiswa dengan NIM " << mhs.noMhs << " tidak ditemukan" << endl;
    }
}

void deleteData(dataMahasiswa mhs) {
    dataMahasiswa mhsNilai;
    ifstream readFile;
    readFile.open("dataMahasiswa.txt", ios::binary);
    ofstream writeFile;
    writeFile.open("tmp.txt", ios::out|ios::binary);
    int find = 0;
    while(readFile.read((char *) &mhsNilai, sizeof(mhsNilai))) {
        if(mhsNilai.noMhs != mhs.noMhs) {
            writeFile.write((char *) &mhsNilai, sizeof(mhsNilai));
        } else {
            find = 1;
        }
    }
    readFile.close();
    writeFile.close();
    remove("dataMahasiswa.txt");
    rename("tmp.txt", "dataMahasiswa.txt");
    if(find) {
        cout << "Mahasiswa dengan NIM " << mhs.noMhs << " telah dihapus" << endl;
    } else {
        cout << "Mahasiwa dengan NIM " << mhs.noMhs << " tidak berhasil dihapus " << endl;
    }
}

void updateData(dataMahasiswa mhs) {
    cout << "Data yang ingin di edit\t: "; cin >> infoMhs.nim;

}

int main() {
    char menu;
    dataMahasiswa mhsNilai;
    createBST();
    readData();
    do {
        cout << "---Implementasi Binary Search Tree dengan Struct---" << endl;
        cout << "-----------Data Mahasiswa-------------" << endl;

        cout << "MENU" << endl;
        cout << "1. INPUT DATA" << endl;
        cout << "2. OUTPUT DATA" << endl;
        cout << "3. DELETE DATA" << endl;
        cout << "4. EDIT DATA" << endl;
        cout << "5. SEARCH DATA" << endl;

        cout << "Pilih\t: "; cin >> menu;
        switch(menu) {
            case '1':
                cout << "---INPUT DATA---" << endl;
                cout << "No Mahasiswa\t: "; cin >> mhsNilai.noMhs; cin.ignore();
                cout << "Nama\t\t: "; cin.getline(mhsNilai.nama, sizeof(mhsNilai.nama));//cin.getline(mhsNilai.nama, sizeof(mhsNilai.nama));
                cout << "Nilai UTS\t: "; cin >> mhsNilai.uts;
                cout << "Nilai UAS\t: "; cin >> mhsNilai.uas;
                mhsNilai.akhir = (0.4 *  mhsNilai.uts) + (0.6 * mhsNilai.uas);
                cout << "Nilai Akhir\t: " << mhsNilai.akhir << endl << endl;
                insertNode(mhsNilai);
                insertData(mhsNilai);
                cout << endl;
                break;
            case '2':
                printNode();
                break;
            case '3':
                if(totalNode(dataNilai)) {
                    cout << "Data yang ingin di hapus\t: "; cin >> mhsNilai.noMhs;
                    hapusnode(mhsNilai);
                    deleteData(mhsNilai);
                } else {
                    cout << "Data belum tersedia!" << endl;
                }
                break;
            case '4':
                cout << "Update data mahasiswa\t: " << endl;
                cout << "Cari NIM\t: "; cin >> mhsNilai.noMhs;
                updateData();
                break;
            case '5':
                cout << "Cari data mahasiswa\t: " << endl;
                cout << "Cari NIM\t: "; cin >> mhsNilai.noMhs;
                searchData(mhs);
                break;
            default:
                cout << "Salah pilih menu" << endl;
        }
        cout << "Ingin kembali ke menu utama? (y/n)\t: "; cin >> menu;
        if(menu == 'n'||menu=='N') break;
        system("cls");
    } while(true);
    delete[] dataNilai;
    return 0;
}
