import React from "react";

export default function NilaiList() {
    return <>
        <div>
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Nilai</h6>
                </div>
                <div class="card-body">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Jurusan</th>
                                <th scope="col">Ujian</th>
                                <th scope="col">Nama</th>
                                <th scope="col">Nilai</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <th scope="row">1</th>
                                <td>Teknik Informatika</td>
                                <td>UTS Ganjil</td>
                                <td>John Doe</td>
                                <td>100</td>
                            </tr>
                            <tr>
                                <th scope="row">2</th>
                                <td>Teknik Informatika</td>
                                <td>UTS Ganjil</td>
                                <td>John Doe</td>
                                <td>100</td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Teknik Informatika</td>
                                <td>UTS Ganjil</td>
                                <td>John Doe</td>
                                <td>100</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </>
}