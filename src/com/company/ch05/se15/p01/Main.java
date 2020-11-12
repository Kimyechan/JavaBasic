package com.company.ch05.se15.p01;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * nio (New Input/Output)
 * nonblocking-io (x)
 *
 * io stream : 입력 노드/ 출력 노드가 구분
 * nio channel : 입/출력 모두 처리 가능
 *
 * - 채널을 이용해서 입/출력을 모두 처리 (동시애는 안됨)
 * - 기본적으로 버퍼를 사용
 * - nio는 non-blocking을 지원 (비동기식)
 *  - 읽기/쓰기를 시켜놓고 다른 작업 진행 가능 (멀티 쓰레드)
 */
public class Main {
    public static void main(String[] args) throws URISyntaxException {
        Path path = Paths.get("1.txt");
        Path path1 = Paths.get("Users", "yechan", "1.txt");
        Path path2 = Paths.get(new URI("file:///Users/yechan/1.txt"));

        // Paths -> get 정적 메소드
        // Files -> createFile, createDirectory, delete, copy, move

        // Buffer: Direct buffer, non-direct buffer
        // Direct buffer : OS에 직접 요청
        //      -> 사용가능한 크기가 큼(JVM 제한 x),
        //      생성 속도는 느림(OS와 통신 필요),
        //      입출력 성능은 좋음
        //      ByteBuffer 만 생성가능, nio는 ByteBuffer를 사용

        // Non-direct buffer: JVM 메모리
        //      -> 사용 가능한 메모리 작은편(JVM 에 의해 제한),
        //      -> 생성 속도가 빠름(JVM상에 곧바로 사용),
        //      -> 입출력 성능은 Direct buffer에 비해 떨어짐

        ByteBuffer buff = ByteBuffer.allocateDirect(1024); // Direct Buffer
        ByteBuffer buff1 = ByteBuffer.allocate(1024); // Non Direct Buffer

        CharBuffer cBuff = CharBuffer.allocate(1024);
        IntBuffer iBuff = IntBuffer.allocate(1024);
        // ByteBuffer 외 다른 버퍼는 allocateDirect 없음

        DoubleBuffer dBuff = buff.asDoubleBuffer();

        Path src = Paths.get("1.txt");
        Path dst = Paths.get("2.txt");

        try (FileChannel channel1 = FileChannel.open(src, StandardOpenOption.READ);
             FileChannel channel2 = FileChannel.open(dst, StandardOpenOption.WRITE, StandardOpenOption.CREATE)){

            int read = -1;
            ByteBuffer readBuffer = ByteBuffer.allocate((int) channel1.size());
            read = channel1.read(readBuffer);
            if (read == -1) {
                throw new IOException();
            }

            readBuffer.flip(); // 현재 position을 limit으로 설정하고 position를 0로 이동 -> 현재 어디까지 사용되는가 파악
            channel2.write(readBuffer);
            readBuffer.clear(); // buffer를 지우고 position을 0으로 limit을 capacity로 이동

            // buffer 사용법
            // capacity, limit, position, mark
            // 0 <= mark <= position <= limit <= capacity

        } catch (IOException e) {
            e.printStackTrace();
        }

        Path src1 = Paths.get("1.txt");
        Path dst1 = Paths.get("3.txt");

        try (FileChannel channel3 = FileChannel.open(src1, StandardOpenOption.READ);
             FileChannel channel4 = FileChannel.open(dst1, StandardOpenOption.WRITE, StandardOpenOption.CREATE)){

            int read = -1;
            ByteBuffer readBuffer = ByteBuffer.allocate(8); // allocate -> allocateDirect, 버퍼 크기를 변경하여 최적화 가능
            read = channel3.read(readBuffer);
            if (read == -1) {
                throw new IOException();
            }

            while((read = channel3.read(readBuffer)) != -1) {
                readBuffer.flip();
                channel4.write(readBuffer);
                readBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
