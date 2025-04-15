import java.util.Scanner;

public class MyMain {
    
    //TULISKAN KOMENTAR UNTUK SETIAP BARIS YANG ANDA BUAT!!!
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //scanner
		int ch = sc.nextInt();				// pilihan fungsi atau keluar
		while(ch!=0) {					//selama tidak memilih keluar
			if (1==ch) {
				MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble()); //input 2 point p q. buat object point baru dengan param x dan y (double)
				MyPoint q = new MyPoint(sc.nextDouble(),sc.nextDouble());
				System.out.printf("%.3f", p.distanceToOtherPoints(q));//print jarak ke point lain dengan ketepatan 3 angka belakang koma
			}
			else if (2==ch) {
				MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble()); //input 3 point p q r. buat object point baru dengan param x dan y (double)
				MyPoint q = new MyPoint(sc.nextDouble(),sc.nextDouble());
				MyPoint r = new MyPoint(sc.nextDouble(),sc.nextDouble()); 
				MyLineSegment l = new MyLineSegment(q,r); //buat object line segment dengan point q dan r
				System.out.printf("%.3f", l.distanceToPoint(p));//print jarak line segement ke point dengan ketepatan 3 angka belakang koma
			}
			else if (3==ch) { //fungsi 3
				MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble());
				MyPoint q = new MyPoint(sc.nextDouble(),sc.nextDouble());
				MyPoint r = new MyPoint(sc.nextDouble(),sc.nextDouble());
				MyLineSegment l = new MyLineSegment(p,q); //segmen garis/vektor dari p ke q
				double res = l.leftTurnToPoint(r); // dari p ke q ke r apakah belok kiri/kanan/lurus
				String arah = new String("Kolinear");
				if (res<0.0) arah = "Kanan";
				else if (res>0.0) arah = "Kiri";
				System.out.println(arah);
			}
			else if (4==ch) {
				MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble()); //input 4 point p q r s. buat object point baru dengan param x dan y (double)
				MyPoint q = new MyPoint(sc.nextDouble(),sc.nextDouble());
				MyPoint r = new MyPoint(sc.nextDouble(),sc.nextDouble());
				MyPoint s = new MyPoint(sc.nextDouble(),sc.nextDouble());
				MyLineSegment l = new MyLineSegment(p,q); //buat 2 object line segment dengan point p q dan r s
				MyLineSegment m = new MyLineSegment(r,s);
				if (l.isIntersect(m))//jika saling intersect, print ya
					System.out.println("Ya");
				else//jika tidak, print tidak
					System.out.println("Tidak");
			}
			else if (5==ch) {
				MyPolygon polygon = new MyPolygon();//init polygon baru
				int n = sc.nextInt();//input banyak point yang akan dijadikan polygon
				for (int i = 0; i < n; i++) {//untuk setiap point
					MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble());//input point
					polygon.addPoint(p);//tambahkan ke polygon
				}
				if (polygon.isConvex())//jika polygon convex, print convex
					System.out.println("Convex");
				else//jika polygon concave, print concave
					System.out.println("Concave");
			}
			else if (6==ch) {
				MyPolygon polygon = new MyPolygon();//buat polygon baru (sama seperti 5)
				int n = sc.nextInt();
				for (int i = 0; i < n; i++) {
					MyPoint p = new MyPoint(sc.nextDouble(),sc.nextDouble());
					polygon.addPoint(p);
				}
				System.out.printf("%.3f", polygon.area());//print luas polygon
			}
			else if (7==ch) {}
			else if (8==ch) {}			
			ch = sc.nextInt();				// pilihan berikutnya
		}
		sc.close();
        //System.out.println(CG.ccw(p,q,t));
    }
}

/*
Implementasikan fungsi-fungsi untuk menghitung:
1. Jarak antara 2 buah titik
2. Jarak sebuah titik ke sebuah segmen garis
3. Posisi sebuah titik terhadap sebuah segmen garis (kiri, kanan, atau lurus/colinear)
4. Apakah dua buah segmen garis saling berpotongan?
Jika titik pada satu segmen menyentuh segmen/titik ujung dari segmen yang lain, maka dianggap berpotongan
5. Apakah sebuah simple polygon itu convex atau concave
6. Menghitung luas simple polygon
7. Apakah sebuah titik berada di dalam atau di luar sebuah simple polygon?
Jika titik berimpitan dengan poligon/terletak pada sisi poligon, maka dianggap di dalam
8. Diberikan kumpulan titik di R2, urutkan secara menaik berdasarkan sudut dengan titik paling kiri bawah.

Input terdiri dari beberapa tes kasus.
Untuk setiap tes kasus, sebuah bilangan n menunjukkan nomor fungsi (di atas) yang hendak diuji.
Kemudian, diberikan sejumlah nilai sesuai dengan fungsi tersebut:
1. Dua buah titik p dan q yang dinyatakan dengan 4 buah integer beurutan x1, y1, x2, dan y2, dimana p=(x1,y1) dan q=(x2,y2) 
2. Sebuah titik p dan sebuah segmen garis (terdiri dari dua buah titik q dan r) yang dinyatakan dengan 6 buah integer berurutan x1, y1, x2, y2, x3, dan y3 dimana p=(x1,y1), q =(x2,y2), dan r =(x3,y3)
3. Sama dengan nomor 2, segmen garis berarah dari q menuju r
4. Empat buah titik p, q, r, dan s yang merupakan titik ujung dari dua segmen garis l1={p,q} dan l2={r,s} yang dinyatakan dengan 8 buah integer berurutan x1,y1,x2,y2,x3,y3,x4, dan y4 dimana p=(x1,y1), q=(x2,y2), r=(x3,y3) dan s=(x4,y4) 
5. Sebuah bilangan n>=3 yang menyatakan banyaknya titik pada poligon, diikuti dengan x buah titik yang koordinat-koordinatnya dinyatakan dengan dua buah bilangan x_i dan y_i. 
6. Sama dengan no 5
7. Sama dengan no 5, tetapi ditambah dengan dua buah bilangan x dan y yang menyatakan koordinat sebuah titik
8. Sama dengan no 5
Input diakhiri jika n=0

Spesifikasi output:
Sesuai dengan tes kasus yang diberikan, tampilkan untuk setiap fungsi:
1. Jarak dengan ketepatan 3 angka di belakang koma
2. Jarak dengan ketepatan 3 angka di belakang koma
3. "Kiri", "Kanan", atau "Kolinear"
4. "Ya" jika berpotongan atau "Tidak" jika tidak
5. "Convex" jika convex atau "Concave" jika concave
6. Luas poligon dengan ketepatan 3 angka di belakang koma
7. "In" jika di dalam atau "Out" jika di luar
8. Bilangan n diikuti dengan n buah titik (dinyatakan dalam koordinat x dan y pisahkan dengan spasi) satu titik dalam tiap baris

Contoh input-output
CONTOH INPUT
1			==>input, kasus pertama, menguji fungsi ke-1
0 0 3 3  		==>input data untuk kasus pertama
2        		==>input, kasus kedua, menguji fungsi ke-2
1 1 0 0 -10 0	==> input data untuk kasus kedua 
3
1 1 0 0 -10 0
4
50 20 76 -12 4 8 92 23
5		==> input, kasus kelima, menguji fungsi ke-5
4		==> poligon terdiri dari 4 buah titik
2 -3 	==> titik pertama dari poligon
4 8 		==> titik kedua dari poligon
-3 3 	==> titik ketiga
-7 1 	==> titik keempat. Jadi poligon: (2,-3),(4,8)(-3,3)(-7,1), titik2nya sudah terurut berlawanan arah jarum jam
6
4		==> poligon terdiri dari 4 buah titik, sudah terurut berlawanan arah jarum jam		
2 -3 
4 8 
-3 3 
-7 1
7		==> input, kasus ketujuh, menguji fungsi ke-7
4		==> poligon terdiri dari 4 buah titik, sudah terurut berlawanan arah jarum jam
2 -3		
4 8
-3 3
-7 1  
0 0 		==> koordinat titik yang akan diperiksa apakah ada di dalam atau di luar
8		==> input, kasus kedelapan, menguji fungsi ke-8					
5		==> n=banyak titik. Himpunan terdiri dari 5 titik, tidak ada keterurutan tertentu
4 7		==> titik pertama
10 1		==> titik kedua
0 0
1 4
7 3
0		==> akhir input

CONTOH OUTPUT
4.243 	==>output kasus pertama
1.414	==>output kasus kedua
Kanan	==>output kasus ketiga
Ya 		==>output kasus keempat
Concave	==>output kasus kelima
50.500	==>output kasus keenam
In		==>output kasus ketujuh
5		==>output kasus kedelapan, ada 5 titik yang memiliki keterurutan tertentu
0 0		==> titik paling kiri bawah
10 1
7 3
4 7
1 4		
 * 
 */
