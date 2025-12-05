package kontuKorrontea;

public class MugikorAurreordainketa {

    public long mugikorZenb;
    final private float deiEzarriKostea;
    final private float deiMinutuKostea;
    final private float mBKontsumoKostea;
    private float saldoa;

    
    
    public MugikorAurreordainketa() {
		this.mugikorZenb = 0;
		this.deiEzarriKostea = 0.0f;
		this.deiMinutuKostea = 0.0f;
		this.mBKontsumoKostea = 0.0f;
		this.saldoa = 0.0f;
	}

	MugikorAurreordainketa(long mZ, float dEK, float dMK, float mBK, float s) {
        mugikorZenb = mZ;
        deiEzarriKostea = dEK;
        deiMinutuKostea = dMK;
        mBKontsumoKostea = mBK;
        saldoa = s;
    }

    public void deitu(int segundoak) {
        saldoa -= Math.round(
                (deiEzarriKostea + deiMinutuKostea / 60f * segundoak) * 100f) / 100f;
        if (saldoa < 0) {
            saldoa = 0;
        }
    }

    public void nabigatu(int mb) {
        saldoa -= Math.round(mBKontsumoKostea * mb * 100f) / 100f;
        if (saldoa < 0) {
            saldoa = 0;
        }
    }

    public boolean birkargatu(int kopurua) {
        if (kopurua % 5 == 0) {
            saldoa += kopurua;
            return true;
        } else {
            return false;
        }
    }

    public float saldoaKontsultatu() {
        return saldoa;
    }

	@Override
	public String toString() {
		return "MugikorAurreordainketa [mugikorZenb=" + mugikorZenb + ", saldoa=" + saldoa + "]";
	}
    
    
} //fin 